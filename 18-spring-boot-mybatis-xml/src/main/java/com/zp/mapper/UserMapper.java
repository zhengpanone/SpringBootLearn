package com.zp.mapper;

import com.zp.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {

    List<User> getAll();
    void update(User user);
    User getOne(Long id);

   /* void insert(User user);

    void update(User user);

    void delete(long id);*/
}
