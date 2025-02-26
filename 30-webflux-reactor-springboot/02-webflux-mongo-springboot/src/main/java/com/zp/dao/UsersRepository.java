package com.zp.dao;

import com.zp.pojo.Users;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;

/**
 * UsersRepository
 *
 * @author zhengpanone
 * @since 2022-01-18
 */
public interface UsersRepository extends ReactiveSortingRepository<Users,Long> {
}
