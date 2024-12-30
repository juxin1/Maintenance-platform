package edu.tute.mapper;

import edu.tute.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getUser();

    void updateUser(User user);

    void deleteUser(Integer userId);
}
