package edu.tute.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*
* 后端统一返回结果
* */
public class Result {
    private Integer code;       //编码，1成功  0失败
    private String message;         //错误信息
    private Object data;        //数据

    public static Result success() {
        Result result = new Result();
        result.code = 1;
        result.message = "success";
        return result;
    }

    public static Result success(Object object) {
        Result result = new Result();
        result.data = object;
        result.code = 1;
        result.message = "success";
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.code = 0;
        result.message = msg;
        return result;
    }
}