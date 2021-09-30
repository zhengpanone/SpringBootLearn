package com.zp.dao;

import com.zp.App;
import com.zp.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class UserRepositoryQueryAnnotationTest {
    @Autowired
    private UserRepositoryQueryAnnotation userRepositoryQueryAnnotation;

    @Test
    public void testQueryByNameHQL() {
        List<User> list = userRepositoryQueryAnnotation.queryByNameHQL("张三");
        System.out.println(list);

    }

    @Test
    public void testQueryByNameUseSQL() {
        List<User> list = userRepositoryQueryAnnotation.queryByNameUseSQL("张三");
        System.out.println(list);

    }

    @Test
    @Transactional // @Transactional 和@Test 一起使用是事务自动回滚的
    @Rollback(false) //取消回滚
    public void testUpdateUserNameById() {
        userRepositoryQueryAnnotation.updateUserNameById("李四", 2);


    }
}
