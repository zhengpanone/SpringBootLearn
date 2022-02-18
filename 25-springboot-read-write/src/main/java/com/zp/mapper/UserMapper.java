package com.zp.mapper;

import com.zp.entity.UserEntity;

import java.util.List;

/**
 * UserMapper
 *
 * @author zhengpanone
 * @since 2022-01-11
 */
public interface UserMapper {
    int insert(UserEntity userEntity);

    List<UserEntity> findAll();
}
