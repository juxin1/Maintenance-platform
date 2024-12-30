package edu.tute.mapper;

import edu.tute.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    void register(User user);

    User getUser(User user);

    User getUsernameAndPassword(User user);
}
