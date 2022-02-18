package com.zp.controller;

import com.zp.pojo.ResultData;
import com.zp.pojo.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserValidateController
 *
 * @author zhengpanone
 * @since 2022-01-06
 */
@RestController
public class UserValidateController {
    @PostMapping("/save")
    public ResultData save(@RequestBody UserDTO userDTO){
        return  ResultData.success();
    }
}
