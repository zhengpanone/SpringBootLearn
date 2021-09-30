package com.zp.dao;

import com.zp.App;
import com.zp.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class UserRepositoryByNameTest {
    @Autowired
    private UserRepositoryByName userRepositoryByName;

    @Test
    public void testFindByName() {
        List<User> list = userRepositoryByName.findByName("张三");
        System.out.println(list);
    }

    @Test
    public void testFindByNameAndAge() {
        List<User> list = userRepositoryByName.findByNameAndAddress("张三", "湖北");
        System.out.println(list);
    }

    @Test
    public void testFindByNameLike() {
        List<User> list = userRepositoryByName.findByNameLike("%张%");
        System.out.println(list);
    }

    @Test
    public void testFindByNameStartWith() {
        List<User> list = userRepositoryByName.findByNameStartingWith("张");
        System.out.println(list);
    }
}
