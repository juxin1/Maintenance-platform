package edu.tute.service;

import com.github.pagehelper.Page;
import edu.tute.pojo.PageResult;
import edu.tute.pojo.QueryParam;
import edu.tute.pojo.User;

import java.util.List;

public interface UserService {

    /*
    * 查询所有用户(分页)
    * */
    PageResult<User> getUser(QueryParam queryParam);

    /*
    * 修改用户信息
    * */
    void updateUser(User user);

    /*
    * 删除用户
    * */
    void deleteUser(Integer userId);
}
