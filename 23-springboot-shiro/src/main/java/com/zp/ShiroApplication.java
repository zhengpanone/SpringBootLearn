package com.zp;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: zhengpanone
 * @Description:
 * @Date:Created in 2021/07/22 16:32.
 * @Email zhengpanone@hotmail.com
 * @Modified By:
 * https://mp.weixin.qq.com/s/kIeMFdMh0og2cBtUSEUbtQ
 */
@SpringBootApplication
public class ShiroApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ShiroApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
