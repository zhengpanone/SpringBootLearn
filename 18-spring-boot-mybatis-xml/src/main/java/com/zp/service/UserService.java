package com.zp.service;

import com.zp.model.User;

import java.util.List;

/**
 * UserService
 *
 * @author zhengpanone
 * @since 2022-02-18
 */
public interface UserService {
    List<User> findAll();

    User findOne(Long id );

}
