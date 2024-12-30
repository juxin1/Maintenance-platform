package edu.tute.config;

import edu.tute.filter.TokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;


//配置过滤器
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<TokenFilter> loggingFilter(){
        FilterRegistrationBean<TokenFilter> registrationBean = new FilterRegistrationBean<>();

        TokenFilter tokenFilter = new TokenFilter();
        registrationBean.setFilter(tokenFilter);
        registrationBean.addUrlPatterns("/*");
        // 如果需要设置过滤器的执行顺序，可以使用以下方法
        //registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        
        return registrationBean;
    }
}