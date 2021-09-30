package com.zp.dao;

import com.zp.App;
import com.zp.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class UserRepositoryCrudRepositoryTest {
    @Autowired
    private UserRepositoryCrudRepository userRepositoryCrudRepository;

    @Test
    public void testSave() {
        User user = new User();
        user.setName("王五");
        user.setAge(30);
        user.setAddress("贵州");
        User user1 = userRepositoryCrudRepository.save(user);
        System.out.println(user1);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(3);
        user.setName("张三丰");
        user.setAge(30);
        user.setAddress("武当山");
        User user1 = userRepositoryCrudRepository.save(user);
        System.out.println(user1);
    }

    @Test
    public void testCurdRepositoryFindOne() {

        Optional<User> userById = userRepositoryCrudRepository.findById(3);
        System.out.println(userById);
    }

    @Test
    public void testCurdRepositoryFindAll() {

        Iterable<User> all = userRepositoryCrudRepository.findAll();
        System.out.println(all);
    }

    @Test
    public void testCurdRepositoryDelete() {

        userRepositoryCrudRepository.deleteById(2);
        
    }

}
