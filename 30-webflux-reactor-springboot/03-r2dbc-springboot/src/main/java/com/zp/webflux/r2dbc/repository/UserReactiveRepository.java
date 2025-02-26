package com.zp.webflux.r2dbc.repository;

import com.zp.webflux.r2dbc.entity.Users;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Author : zhengpanone
 * Date : 2025/2/26 10:46
 * Version : v1.0.0
 * Description:
 * https://mp.weixin.qq.com/s/Tm5iNTBbznUy4b_lMQgsqw
 */
@Repository
public interface UserReactiveRepository extends ReactiveSortingRepository<Users, Long> {
    Mono<Integer> deleteByLastname(String lastname);

    Mono<Integer> deleteUsersByLastname(String lastname);

    @Modifying
    @Query("UPDATE T_USERS SET firstname = :firstname where lastname = :lastname")
    Mono<Integer> setFixedFirstnameFor(String firstname, String lastname);
}
