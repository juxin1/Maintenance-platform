package edu.tute.service;

import edu.tute.pojo.LoginInfo;
import edu.tute.pojo.User;

public interface LoginService {

    /*
    * 注册
    * */
    boolean register(User user);

    /*
    * 登录
    * */
    LoginInfo selectUser(User user);
}
