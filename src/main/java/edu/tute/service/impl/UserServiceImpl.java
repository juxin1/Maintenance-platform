package edu.tute.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.tute.mapper.UserMapper;
import edu.tute.pojo.PageResult;
import edu.tute.pojo.QueryParam;
import edu.tute.pojo.User;
import edu.tute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageResult<User> getUser(QueryParam queryParam) {
        PageHelper.startPage(queryParam.getPage(), queryParam.getPageSize());
        List<User> users = userMapper.getUser();
        Page<User> userPage = (Page<User>) users;
        return new PageResult<>(userPage.getTotal(), userPage.getResult());
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userMapper.deleteUser(userId);
    }
}
