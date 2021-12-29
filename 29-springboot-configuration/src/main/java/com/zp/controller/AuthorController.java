package com.zp.controller;

import com.zp.config.ConfigFile;
import com.zp.config.ConfigFile2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthorController
 *
 * @author zhengpanone
 * @since 2021-12-27
 */
@RestController
public class AuthorController {
    @Autowired
    ConfigFile configFile;

    @Autowired
    ConfigFile2 configFile2;

    @GetMapping("/")
    public String index(){
        return "author name is "+configFile.getName();
    }
    @GetMapping("/2")
    public String index2(){
        return "author name is "+configFile2.getName();
    }
}
