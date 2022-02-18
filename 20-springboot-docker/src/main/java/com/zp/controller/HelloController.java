package com.zp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhengpanone
 * @Description:
 * @Date:Created in 2021/07/19 15:27.
 * @Email zhengpanone@hotmail.com
 * @Modified By:
 */

@RestController
@Slf4j
public class HelloController {
@RequestMapping(value = "/", method = RequestMethod.GET)
    public String test() {
        System.out.println("这是控制台日志");
        log.info("这是输出到文件的日志");
        return "Hello SpringBoot Docker";
    }
}
