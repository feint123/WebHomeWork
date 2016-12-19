package com.example.controller;

import com.example.entity.LoginEntity;
import com.example.entity.ResponseEntity;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by feint on 16/12/13.
 */
@RestController
public class LoginController {
    @Autowired
    UserService userService;
    /**
     * 返回值
     *  1:表示登录成功
     *  2:用户名不存在
     *  3:密码错误
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping("/login")
    public ResponseEntity<LoginEntity> login(@RequestParam("name")String name, @RequestParam("pwd")String pwd){
        return userService.userLogin(name,pwd);
    }
}
