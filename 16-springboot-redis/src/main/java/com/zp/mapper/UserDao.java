package com.zp.mapper;

import com.zp.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user")
    List<User> queryAll();

    @Select("select * from user where uid = #{id}")
    User findUserById(int id);

    @Update("UPDATE USER SET userName = #{user.userName}," +
            "passWord = #{user.passWord}, " +
            "salary =  #{user.salary} WHERE uid = #{user.uid}")
    int updateUser(@Param("user") User user);

    @Delete("delete from user where uid= #{id}")
    int deleteUserById(int id);
}
