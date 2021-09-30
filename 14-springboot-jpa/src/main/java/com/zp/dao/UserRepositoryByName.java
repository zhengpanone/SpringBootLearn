package com.zp.dao;

import com.zp.pojo.User;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepositoryByName extends Repository<User, Integer> {
    //方法名称必须遵循驼峰式命名规则,查询关键字findBy+属性名称(首字母要大写)+查询条件(首字母大写)
    List<User> findByName(String name);

    List<User> findByNameAndAddress(String name, String address);

    List<User> findByNameLike(String name);

    List<User> findByNameStartingWith(String name);
}
