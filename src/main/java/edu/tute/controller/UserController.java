package edu.tute.controller;

import com.github.pagehelper.Page;
import edu.tute.pojo.PageResult;
import edu.tute.pojo.QueryParam;
import edu.tute.pojo.Result;
import edu.tute.pojo.User;
import edu.tute.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    /*
     * 查询所有用户(分页)
     * */
    @GetMapping
    public Result getUser(QueryParam queryParam) {
        log.info("查询所有用户，参数为：{}", queryParam);
        PageResult<User> userList = userService.getUser(queryParam);
        return Result.success(userList);
    }

    /*
     * 修改用户信息
     * */
    @PutMapping()
    public Result updateUser(@RequestBody User user) {
        log.info("修改用户信息，用户id为：{}", user.getUserId());
        userService.updateUser(user);
        return Result.success();
    }

    /*
    * 删除用户
    * */
    @DeleteMapping("/{userId}")
    public Result deleteUser(@PathVariable("userId") Integer userId) {
        log.info("删除用户，用户id为：{}", userId);
        userService.deleteUser(userId);
        return Result.success();
    }

}
