package com.zp.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
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

@Data
public class ConfigFile {
    @Value("${author.name}")
    private String name;
    @Value("${author.age}")
    private int age;

}
