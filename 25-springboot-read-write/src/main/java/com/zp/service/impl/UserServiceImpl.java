package com.zp.service.impl;

import com.zp.annotation.Master;
import com.zp.entity.UserEntity;
import com.zp.mapper.UserMapper;
import com.zp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * MemberServiceImpl
 *
 * @author zhengpanone
 * @since 2021-09-22
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public int insert(UserEntity member) {
        return userMapper.insert(member);
    }

    @Master
    @Override
    public int save(UserEntity userEntity) {
        return userMapper.insert(userEntity);
    }

    @Override
    public List<UserEntity> selectAll() {
        return userMapper.findAll();
    }

    @Override
    public String getToken(String appId) {
        return null;
    }
}
