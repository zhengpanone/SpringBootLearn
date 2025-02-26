package com.zp.service;

import com.mongodb.client.result.UpdateResult;
import com.zp.dao.UsersRepository;
import com.zp.pojo.Users;
import jdk.nashorn.internal.objects.annotations.Where;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

import java.util.regex.Pattern;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

/**
 * UserService
 *
 * @author zhengpanone
 * @since 2022-01-18
 */
@Service
public class UserService {
    @Resource
    private ReactiveMongoTemplate template;
    @Resource
    private UsersRepository usersRepository;

    // 保存数据
    public Mono<Users> save(Users users) {
        return usersRepository.save(users);
    }

    public Mono<UpdateResult> updateInfo(Users user) {
        return template.updateFirst(query(where("id").is(user.getId())),
                update("email", user.getEmail()).set("username", user.getUsername()), Users.class);
    }

    public Mono<Void> removeById(Long id) {
        return usersRepository.deleteById(id);
    }

    // 模糊查询
    public Flux<Users> findUserLike(String keyword) {
        Pattern pattern = Pattern.compile("^.*" + keyword + ".*$");
        return template.find(query(where("username").regex(pattern)), Users.class);

    }

    public Flux<Users> findAll() {
        return template.findAll(Users.class);
    }

    public Flux<Users> queryPage(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Query query = new Query();
        return template.find(query.with(pageable), Users.class);
    }


}
