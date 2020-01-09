package com.hjming.layui.system.user.controller;

import com.hjming.layui.system.shiro.config.UserUtil;
import com.hjming.layui.system.user.domain.Permission;
import com.hjming.layui.system.user.mapper.UserMapper;
import com.hjming.layui.system.user.domain.User;
import com.hjming.layui.system.user.service.PermissionService;
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
@RequestMapping("system")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PermissionService permissionService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("index")
    public String toUserList() {
        return "index";
    }

    @GetMapping("/userList")
    public String userList() {
        return "system/user/userList";
    }

    @GetMapping("/unAuth")
    public String unAuth() {
        return "unAuth";
    }


    @GetMapping("/queryUser")
    @ResponseBody
    public List<User> queryAllUser() {
        return userMapper.selectAll();
    }



}
