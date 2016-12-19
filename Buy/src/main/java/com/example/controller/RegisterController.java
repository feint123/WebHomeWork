package com.example.controller;

import com.example.domain.User;
import com.example.entity.ResponseEntity;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by feint on 16/12/13.
 */
@RestController
public class RegisterController {
    @Autowired
    UserService userService;
    /**
     * 返回值
     *  1:注册成功
     *  2:用户名已存在
     *  3:邮箱已存在
     * @param user
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseEntity<Integer> register(@RequestBody User user){
        return userService.userRegister(user);
    }
}
