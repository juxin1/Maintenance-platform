package edu.tute.filter;

import edu.tute.utils.CurrentHolder;
import edu.tute.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/*
 * 令牌校验过滤器(和拦截器开一个即可，不然浪费性能，如果开启两个，先经过过滤器，在经过拦截器)
 * 过滤器范围更广(全局)，拦截器只作用spring中的请求，过滤器作用servlet的请求
 * */
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(com.fasterxml.jackson.core.filter.TokenFilter.class);

    //初始化, 只执行一次(一般用不到，可以不重写此方法)
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("TokenFilter初始化");
    }

    //拦截请求，放行请求，可以调用多次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强转
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取请求路径
        String requestURI = request.getRequestURI(); // /employee/basic/salarys
        //判断是否为登录请求
        if (requestURI.contains("/login")) {
            log.info("登录请求，放行");
            filterChain.doFilter(request, response);
            return;
        }
        //获取请求头中的令牌
        String token = request.getHeader("token");
        //判断令牌是否为空
        if (token == null || token.isEmpty()) {
            log.info("令牌为空，拦截请求，响应401状态码");
            //设置状态码(401)
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        //解析令牌
        try {
            Claims claims = JwtUtils.parseToken(token);
            Integer empId = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(empId);
            log.info("令牌校验通过，当前用户id为：{} ,将其存入ThreadLocal", empId);
        } catch (Exception e) {
            log.info("令牌校验失败，拦截请求，响应401状态码");
            //设置状态码(401)
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        //放行请求
        log.info("令牌校验通过，放行请求");
        filterChain.doFilter(request, response);
        //移除ThreadLocal中的员工id
        CurrentHolder.remove();
    }

    //销毁，web服务器关闭时调用，只执行一次(一般用不到，可以不重写此方法)
    @Override
    public void destroy() {
        log.info("TokenFilter销毁");
    }
}
