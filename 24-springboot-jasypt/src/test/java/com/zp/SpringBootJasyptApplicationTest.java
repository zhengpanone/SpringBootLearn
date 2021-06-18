package com.zp;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBootJasyptApplicationTest
 *
 * @author zhengpanone
 * @since 2021-09-03
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootJasyptApplicationTest {
    /**
     * 注入加密方法
     */
    @Autowired
    private StringEncryptor encryptor;

    /**
     * 手动生成密文
     */
    @Test
    public void encrypt(){
        String url = encryptor.encrypt("jdbc\\:mysql\\://127.0.0.1\\:3306/test?useUnicode\\=true&characterEncoding\\=UTF-8");
        String name = encryptor.encrypt("root");
        String password = encryptor.encrypt("123456");
        System.out.println("database url: "+url);
        System.out.println(name);
        System.out.println(password);
        Assert.assertTrue(url.length()>0);
        Assert.assertTrue(name.length()>0);
        Assert.assertTrue(password.length()>0);
    }
}
