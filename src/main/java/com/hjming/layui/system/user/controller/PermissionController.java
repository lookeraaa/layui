package com.hjming.layui.system.user.controller;

import com.hjming.layui.system.shiro.config.UserUtil;
import com.hjming.layui.system.user.domain.Permission;
import com.hjming.layui.system.user.domain.User;
import com.hjming.layui.system.user.mapper.UserMapper;
import com.hjming.layui.system.user.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author hjming
 * @version 1.0
 * @date 2020/1/4 16:53
 */
@Controller
@RequestMapping("system")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/permissionList")
    public String permissionList() {
        return "system/permission/permissionList";
    }

    @GetMapping("/queryPermission")
    @ResponseBody
    public List<Permission> queryPermission() {
        return permissionService.queryPermission();
    }

}
