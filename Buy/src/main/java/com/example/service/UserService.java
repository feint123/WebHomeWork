package com.example.service;

import com.example.domain.User;
import com.example.entity.LoginEntity;
import com.example.entity.ResponseEntity;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by feint on 16/12/13.
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public ResponseEntity<Integer> userRegister(User user){
        ResponseEntity<Integer> responseEntity=new ResponseEntity<>();
        if(userMapper.selectUserByEmail(user.getEmail())!=null)
            responseEntity.setCode(ResponseEntity.HAS_EMAIL);
        else if(userMapper.selectUserByName(user.getUname())!=null)
            responseEntity.setCode(ResponseEntity.HAS_USERNAME);
        else {
            userMapper.insertToUser(user);
            responseEntity.setCode(ResponseEntity.SUCCESS);
        }
        return responseEntity;
    }



    public ResponseEntity<LoginEntity> userLogin(String name, String pwd){

        LoginEntity loginEntity=new LoginEntity();
        ResponseEntity<LoginEntity> responseEntity=new ResponseEntity<>();

        if(null==userMapper.selectUserByNameOrEmail(name))
            responseEntity.setCode(ResponseEntity.NO_USER);

        else if(!(userMapper.selectUserByNameOrEmail(name).getPwd().equals(pwd)))
            responseEntity.setCode(ResponseEntity.PASSWORD_WORING);
        else{
            User user=userMapper.selectUserByNameOrEmail(name);
            responseEntity.setCode(ResponseEntity.SUCCESS);
            loginEntity.setUid(user.getUid());
            loginEntity.setUname(user.getUname());
        }
        responseEntity.setData(loginEntity);
        return responseEntity;
    }
}
