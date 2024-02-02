package com.zp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Author : zhengpanone
 * Date : 2024/2/2 11:19
 * Version : v1.0.0
 * Description: TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "thread.pool")
public class ThreadPoolProperties {

    private int coreSize = 2;
    private int maxSize = 5;
    private int queueCapacity = 10;
}
