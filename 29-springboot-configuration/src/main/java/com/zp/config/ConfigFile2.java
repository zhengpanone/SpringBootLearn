package com.zp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * ConfigFile
 *
 * @author zhengpanone
 * @since 2021-12-27
 */
@Component
@PropertySource(value = {"classpath:config/author.yml"},
        ignoreResourceNotFound = true,
        encoding = "UTF-8",name = "author.yml")
@ConfigurationProperties(prefix = "author")
@Data
public class ConfigFile2 {

    private String name;

    private int age;

}
