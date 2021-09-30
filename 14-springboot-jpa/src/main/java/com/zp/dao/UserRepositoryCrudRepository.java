package com.zp.dao;

import com.zp.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryCrudRepository extends CrudRepository<User, Integer> {


}
