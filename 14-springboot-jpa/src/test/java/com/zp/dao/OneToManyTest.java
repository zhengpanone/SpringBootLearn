package com.zp.dao;

import com.zp.App;
import com.zp.pojo.Role;
import com.zp.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class OneToManyTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        User user = new User();
        user.setAddress("天津");
        user.setName("狗不理");
        user.setAge(20);

        Role role = new Role();
        role.setName("管理员");

        role.getUsers().add(user);
        user.setRole(role);

        userRepository.save(user);
    }


    public void testFind() {


    }
}
