package com.zp.mapper;

import com.zp.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * UserMapper
 *
 * @author zhengpanone
 * @since 2022-01-11
 */
@Mapper
public interface UserMapper {
    int insert(UserEntity userEntity);

    List<UserEntity> findAll();
}
