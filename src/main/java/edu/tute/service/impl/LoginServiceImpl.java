package edu.tute.service.impl;


import edu.tute.mapper.LoginMapper;
import edu.tute.pojo.LoginInfo;
import edu.tute.pojo.User;
import edu.tute.service.LoginService;
import edu.tute.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean register(User user) {
        User getUser = loginMapper.getUser(user);
        if (getUser != null) {
            return false;
        } else {
            loginMapper.register(user);
            return true;
        }
    }

    @Override
    public LoginInfo selectUser(User user) {
        User u = loginMapper.getUsernameAndPassword(user);
        if (u == null) {
            return null;
        } else {
            log.info("用户登录成功，用户信息为：{}", u);
            Map<String, Object> claims = new HashMap<>();
            claims.put("userId", u.getUserId());
            claims.put("username", u.getUsername());
            claims.put("roleType", u.getRoleType());
            String token = JwtUtils.generateToken(claims);
            return new LoginInfo(u.getUserId(), u.getUsername(), u.getRoleType(), token);
        }
    }
}
