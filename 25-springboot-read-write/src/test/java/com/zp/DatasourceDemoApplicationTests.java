package com.zp;

import com.zp.entity.UserEntity;
import com.zp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * DatasourceDemoApplicationTests
 *
 * @author zhengpanone
 * @since 2021-09-22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DatasourceDemoApplicationTests {
    @Autowired
    private UserService userService;
    @Test
    public void testWrite() {
        UserEntity user = new UserEntity();
        user.setName("张三");
        user.setId(11);
        userService.save(user);
    }

}
