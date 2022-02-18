package com.zp.service;

import com.zp.entity.UserEntity;

import java.util.List;

/**
 * MemberService
 *
 * @author zhengpanone
 * @since 2021-09-22
 */
public interface UserService {
    public int insert(UserEntity userEntity);
    int save(UserEntity userEntity);
    List<UserEntity> selectAll();
    String getToken(String appId);
}
