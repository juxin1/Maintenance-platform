package edu.tute.pojo;

import lombok.Data;

@Data
public class QueryParam {
    private Integer page = 1;
    private Integer pageSize = 10;
}
