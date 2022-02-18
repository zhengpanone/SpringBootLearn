package com.zp.service.impl;

import com.zp.mapper.UserMapper;
import com.zp.model.User;
import com.zp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 *
 * @author zhengpanone
 * @since 2022-02-18
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> findAll(){
        return  userMapper.getAll();
    }

    @Override
    public User findOne(Long id) {
        return userMapper.getOne(id);
    }
}
