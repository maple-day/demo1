package com.example.demo01.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Integer userId;

    private String username;

    private String phone;

    private String password;

    private String address;
}
