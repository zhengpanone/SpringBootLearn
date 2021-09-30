package com.zp.dao;

import com.zp.App;
import com.zp.pojo.Menu;
import com.zp.pojo.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class ManyToManyTest {
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testSave() {
        Role roe = new Role();
        roe.setName("项目经理");


        Menu menu = new Menu();
        menu.setName("项目管理");
        menu.setUrl("/");
        menu.setP_id(0);

        Menu menu1 = new Menu();
        menu1.setName("新建项目");
        menu1.setP_id(1);

        roe.getMenus().add(menu);
        roe.getMenus().add(menu1);

        menu.getRoles().add(roe);
        menu1.getRoles().add(roe);
        roleRepository.save(roe);

    }

}
