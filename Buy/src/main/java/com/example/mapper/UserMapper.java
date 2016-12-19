package com.example.mapper;

import com.example.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by feint on 16/12/13.
 */
@Mapper
public interface UserMapper {
    @Select("select * from User where uname=#{uname}")
    User selectUserByName(@Param("uname")String name);

    @Select("select * from User where email=#{email}")
    User selectUserByEmail(@Param("email")String email);

    @Select("select * from User where email=#{value} or uname=#{value}")
    User selectUserByNameOrEmail(@Param("value")String value);

    @Insert("insert into User(uname,email,pwd) values(#{user.uname},#{user.email},#{user.pwd})")
    int insertToUser(@Param("user")User user);
}
