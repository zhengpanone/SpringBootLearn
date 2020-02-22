package com.zp.service;

import com.zp.mapper.UserDao;
import com.zp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisTemplate redisTemplate;

    public List<User> queryAll() {
        return userDao.queryAll();
    }

    /**
     * 获取用户策略:先从缓存中获取用户,没有则取数据表中数据,再将数据写入缓存
     *
     * @param id
     * @return
     */
    public User findUserById(int id) {
        String key = "user_" + id;

        ValueOperations valueOperations = redisTemplate.opsForValue();

        Boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            User user = (User) valueOperations.get(key);
            System.out.println("从缓存中获得数据" + user.getUserName());
            return user;
        } else {
            User user = userDao.findUserById(id);
            System.out.println("查询数据库获得数据" + user.getUserName());
            valueOperations.set(key, user, 5, TimeUnit.HOURS);
            return user;
        }

    }

    /**
     * 更新用户策略:先更新数据表,成功后,删除原来的缓存,在更新缓存
     *
     * @param user
     * @return
     */
    public int updateUser(User user) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        int result = userDao.updateUser(user);
        if (result != 0) {
            String key = "user_" + user.getUid();
            Boolean hasKey = redisTemplate.hasKey(key);
            if (hasKey) {
                redisTemplate.delete(key);
                System.out.println("删除缓存中的key------>" + key);
            }
            //再将更新后的数据加入缓存
            User userById = userDao.findUserById(user.getUid());
            if (userById != null) {
                valueOperations.set(key, userById, 3, TimeUnit.HOURS);
            }

        }
        return result;
    }

    /**
     * 删除用户策略:删除数据表中数据,然后删除缓存
     *
     * @param id
     * @return
     */
    public int deleteUserById(int id) {
        int result = userDao.deleteUserById(id);
        String key = "user_" + id;
        if (result != 0) {
            Boolean hasKey = redisTemplate.hasKey(key);
            if (hasKey) {
                redisTemplate.delete(key);
                System.out.println("删除了缓存中的key" + key);
            }
        }
        return result;
    }
}

