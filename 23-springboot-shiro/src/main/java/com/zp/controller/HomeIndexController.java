package com.zp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zhengpanone
 * @Description:
 * @Date:Created in 2021/07/22 16:16.
 * @Email zhengpanone@hotmail.com
 * @Modified By:
 */
@Controller
public class HomeIndexController {

    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return "test";
    }
/*
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String defaultLogin() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println(username);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException unknownAccountException) {
            return "未知账号";
        } catch (IncorrectCredentialsException incorrectCredentialsException) {
            return "密码不正确";
        } catch (LockedAccountException lockedAccountException) {
            return "账号已锁定";
        } catch (ExcessiveAttemptsException excessiveAttemptsException) {
            return "用户名或密码错误次数过多";
        } catch (AuthenticationException authenticationException) {
            return "用户名或密码不正确";
        }
        if (subject.isAuthenticated()) {
            return "登录成功";
        } else {
            token.clear();
            return "登录失败";
        }

    }*/
}
