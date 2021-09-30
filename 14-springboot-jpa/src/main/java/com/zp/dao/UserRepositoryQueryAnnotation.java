package com.zp.dao;

import com.zp.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Repository @Query
 */
public interface UserRepositoryQueryAnnotation extends Repository<User, Integer> {
    @Query("from User where name = ?1 ")
    List<User> queryByNameHQL(String name);

    @Query(value = "select * from t_users u where  u.name = ?1", nativeQuery = true)
    List<User> queryByNameUseSQL(String name);

    @Modifying
    @Query("update  User set name = ?1 where id = ?2")
    void updateUserNameById(String name, Integer id);
}
