package com.zp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhengpanone
 * @date 2021-06-18-11:05
 * @email zhengpanone@hotmail.com
 */
@Controller
public class QuickStartController {
    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        return "Hello SpringBoot!";
    }
}
