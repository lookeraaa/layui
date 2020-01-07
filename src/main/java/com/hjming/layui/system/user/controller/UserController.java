package com.hjming.layui.system.user.controller;

import com.hjming.layui.system.shrio.config.UserUtil;
import com.hjming.layui.system.user.mapper.UserMapper;
import com.hjming.layui.system.user.domain.User;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hjming
 * @version 1.0
 * @date 2020/1/4 16:53
 */
@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("index")
    public String toUserList() {
        return "index";
    }

    @GetMapping("/userList")
    public String userList() {
        return "user/userList";
    }

    @GetMapping("/unAuth")
    public String unAuth() {
        return "unAuth";
    }
    @GetMapping("/queryAllUser")
    @ResponseBody
    public List<User> queryAllUser() {

        User currentUser = UserUtil.getCurrentUser();
        System.out.println(currentUser);

        return userMapper.selectAll();
    }



}
