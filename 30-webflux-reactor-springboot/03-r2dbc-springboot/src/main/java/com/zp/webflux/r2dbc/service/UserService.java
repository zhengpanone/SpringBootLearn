package com.zp.webflux.r2dbc.service;

import com.zp.webflux.r2dbc.entity.Users;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.data.relational.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author : zhengpanone
 * Date : 2025/2/26 10:30
 * Version : v1.0.0
 * Description:
 * https://mp.weixin.qq.com/s/Tm5iNTBbznUy4b_lMQgsqw
 */
@Service
public class UserService {
    @Resource
    private R2dbcEntityTemplate template;

    @Transactional
    public Mono<Users> insertByTemplate(Users users) {
        return template.insert(users);
    }

    public Mono<Integer> removeByTemplate(Long id) {
        Query query = Query.query(Criteria.where("id").is(id));
        return template.delete(query, Users.class);
    }

    public Mono<Integer> updateByTemplate(Users users) {
        Query query = Query.query(Criteria.where("id").is(users.getId()));
        Update update = Update.update("name", users.getName());
        return template.update(query, update, Users.class);
    }

    public Mono<Users> selectByTemplate(Long id) {
        Query query = Query.query(Criteria.where("id").is(id));
        return template.select(query, Users.class).single();
    }

    public Flux<Users> selectByTemplate(Integer page, Integer size) {
        Query query = Query.empty().offset((page - 1) * size).limit(size);
        return template.select(query, Users.class);
    }

    public Mono<Long> selectCountByTemplateCount() {
        return template.count(Query.empty(), Users.class);
    }

    public Mono<ResponseEntity<List<Users>>> selectByTemplatePager(Integer page, Integer size) {
        Mono<List<Users>> data = this.selectByTemplate(page, size).collectList();
        Mono<Long> count = this.selectCountByTemplateCount();
        return data.zipWith(count, (list, c) -> {
            return ResponseEntity.ok()
                    .header("count", String.valueOf(c))
                    .header("page", String.valueOf(page))
                    .header("size", String.valueOf(size))
                    .body(list);
        });

    }
}
