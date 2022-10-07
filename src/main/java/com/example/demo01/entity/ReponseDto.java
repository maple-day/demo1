package com.example.demo01.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReponseDto {

    private Integer code;
    private String msg;
    private Object data;
}
