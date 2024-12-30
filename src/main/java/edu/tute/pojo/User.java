package edu.tute.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId; //用户id
    private String userName;    //用户名
    private String password;    //密码
    private String phoneNumber; //手机号
    private String roleType;    //角色类型
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate registrationDate; //注册时间

}
