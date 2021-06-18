package com.zp.service;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zhengpanone
 * @Description:
 * @Date:Created in 2021/08/04 17:10.
 * @Email zhengpanone@hotmail.com
 * @Modified By:
 */
@Service
public class RedisService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * set string类型
     * @param key key
     * @param value value
     */
    public void setString(String key,String value){
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set(key,value);

    }

    /**
     * get string类型
     * @param key key
     * @return
     */
    public String getString(String key){
        return  stringRedisTemplate.opsForValue().get(key);
    }

    public void setHash(String key,String fieldKey, String value){
        HashOperations<String, Object, Object> stringObjectObjectHashOperations = stringRedisTemplate.opsForHash();
        stringObjectObjectHashOperations.put(key,fieldKey,value);
    }
    public String getHash(String key,String fieldKey){
        return (String)stringRedisTemplate.opsForHash().get(key,fieldKey);
    }

    /**
     * set list类型
     * @param key
     * @param value
     */
    public void setList(String key,String value){
        ListOperations<String, String> stringStringListOperations = stringRedisTemplate.opsForList();
        stringStringListOperations.leftPush(key,value);

    }

    /**
     * get list 类型
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<String> getList(String key, long start, long end){
        return stringRedisTemplate.opsForList().range(key,start,end);
    }
}
