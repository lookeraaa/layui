package com.hjming.layui.system.controller;


import com.hjming.layui.system.shiro.config.UserUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author hjm10
 * @version 1.0
 * @date 2020-01-06 22:17
 */
@Controller
public class LoginController {

    /**
     * 跳转到登录页面
     */
    @GetMapping("toLogin")
    public String toLogin() {
        return "login";
    }


    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try {
            subject.login(token);
            model.addAttribute("name", UserUtil.getCurrentUser().getName());
            return "index";
        } catch (Exception e) {
            model.addAttribute("msg","账号或密码错误");
            return "login";
        }
    }

}
