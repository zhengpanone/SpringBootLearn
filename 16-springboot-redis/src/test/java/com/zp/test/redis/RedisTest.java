package com.zp.test.redis;

import com.alibaba.fastjson.JSON;
import com.zp.pojo.User;
import com.zp.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zhengpanone
 * @Description:
 * @Date:Created in 2021/08/04 17:15.
 * @Email zhengpanone@hotmail.com
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    private static final Logger logger = LoggerFactory.getLogger(RedisTest.class);
    @Resource
    private RedisService redisService;
    User user = new User(1,"张三","123456",5000);
    @Test
    public void loadString(){
        redisService.setString("测试插入String类型","String 类型数据");
        logger.info(redisService.getString("测试插入String类型"));


        redisService.setString("userInfo", JSON.toJSONString(user));
        logger.info(redisService.getString("userInfo"));
    }
@Test
    public void loadHash(){
        redisService.setHash("user","name",JSON.toJSONString(user));
        logger.info(redisService.getHash("user","name"));
    }
    @Test
    public void loadList(){
        redisService.setList("list","java");
        redisService.setList("list","python");
        redisService.setList("list", "javascript");
        List<String> list = redisService.getList("list", 0, -1);
        for(String value:list){
            logger.info("list中有:"+value);
        }
    }
}
