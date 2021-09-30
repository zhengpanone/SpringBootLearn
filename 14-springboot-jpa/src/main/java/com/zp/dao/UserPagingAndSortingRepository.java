package com.zp.dao;

import com.zp.pojo.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<User, Integer> {
}
