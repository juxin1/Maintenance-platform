package edu.tute.controller;

import edu.tute.pojo.LoginInfo;
import edu.tute.pojo.Result;
import edu.tute.pojo.User;
import edu.tute.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public Result Register(@RequestBody User user) {
        log.info("用户注册，用户信息为：{}", user);
        boolean flag = loginService.register(user);
        if (!flag) {
            return Result.error("用户名已存在");
        }else {
            return Result.success();
        }
    }

    @PostMapping("/login")
    public Result Login(@RequestBody User user) {
        log.info("用户登录，用户信息为：{}", user);
        LoginInfo loginInfo = loginService.selectUser(user);
        if (loginInfo == null) {
            return Result.error("用户名或密码错误");
        }else {
            return Result.success(loginInfo);
        }
    }

}
