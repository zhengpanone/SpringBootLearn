package com.zp.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ConfigFileTest
 *
 * @author zhengpanone
 * @since 2021-12-27
 */
@SpringBootTest
@EnableConfigurationProperties
public class ConfigFileTest {
    @Autowired
    ConfigFile configFile;
    @Autowired
    ConfigFile2 configFile2;
    @Test
    public void test1(){
        System.out.println(configFile);
    }

    @Test
    public void test2(){
        System.out.println(configFile2);
        System.out.println(configFile2.getName()+configFile2.getAge());
    }
}
