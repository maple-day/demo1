package com.example.demo01.controller;


import com.example.demo01.entity.ReponseDto;
import com.example.demo01.entity.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//@CrossOrigin(origins = {"*"})
@CrossOrigin(allowCredentials = "true", originPatterns = "*")
@RestController
public class TestController {

    private final static String a = "b3e3e393c77e35a4a3f3cbd1e429b5dc";
    private final static String defaultName = "admin";

    @RequestMapping("/aaa")
    public String demo() {
        return UUID.randomUUID().toString();
    }

    @RequestMapping("userList")
    public List<User> userList() {

        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setUserId(i);
            user.setUsername("姓名" + i);
            user.setPhone(157359281 + "" + i);
            userList.add(user);
        }

        return userList;
    }

    @RequestMapping("login")
    public ReponseDto login(@RequestBody User user, HttpServletRequest request) {

        ReponseDto.ReponseDtoBuilder builder = ReponseDto.builder();

        String name = user.getUsername();
        if (name.equals(defaultName)) {
            builder.code(200).msg("成功").data(a);
        } else {
            builder.code(400).msg("失败");
        }
        ReponseDto build = builder.build();
        return build;
    }

    @RequestMapping("userInfo")
    public ReponseDto userInfo(HttpServletRequest request) {

        User user = new User();
        user.setPhone("15735928103");
        user.setAddress("地址");
        ReponseDto.ReponseDtoBuilder builder = ReponseDto.builder();


        builder.code(200).msg("成功").data(user);

        ReponseDto build = builder.build();
        return build;
    }

}
