package com.zp.controller;

import com.zp.pojo.User;
import com.zp.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserSerivce userSerivce;

    /**
     * 解决异常的方式,可以在跳转页面的方法中注入一个User对象
     * 由于SpringMVC会将该对象放入Model中传递，key名称会使用该对象的驼峰式命名规则来作为key,参数变量名需要与对象的名称相同,将首字母小写
     * 如果想为传递的对象更改名称,可以使用@ModelAttribute("aa")表示当前传递的对象的可以为aa
     * 那么我们在页面中获取该对象的key也需要修改
     * @param page
     * @param user
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page,@ModelAttribute("aa") User user) {
        return page;
    }

    /**
     * @param user
     * @return
     * @Validate 开起对User的校验
     * BindingResult 封装校验结果
     */
    @RequestMapping("/addUser")
    public String addUser(@ModelAttribute("aa") @Validated  User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "input";
        }
        this.userSerivce.addUser(user);
        return "ok";
    }

    @RequestMapping("/findUserAll")
    public String findUserAll(Model model) {
        List<User> allUser = this.userSerivce.getAllUser();
        model.addAttribute("list", allUser);

        return "show_all_user";
    }

    @RequestMapping("/findUserById")
    public String findUserById(Integer id, Model model) {
        User user = this.userSerivce.findUserById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user) {
        this.userSerivce.updateUser(user);
        return "ok";
    }

    @RequestMapping("/deleteUserById")
    public String deleteUserById(Integer id) {
        this.userSerivce.deleteUserById(id);
        return "redirect:/user/findUserAll";
    }
}
