package com.hjming.layui.system.user.controller;

import com.hjming.layui.system.shiro.config.UserUtil;
import com.hjming.layui.system.user.domain.Permission;
import com.hjming.layui.system.user.domain.Role;
import com.hjming.layui.system.user.domain.User;
import com.hjming.layui.system.user.mapper.UserMapper;
import com.hjming.layui.system.user.service.PermissionService;
import com.hjming.layui.system.user.service.RoleService;
import com.hjming.layui.util.ResObject;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hjming
 * @version 1.0
 * @date 2020/1/4 16:53
 */
@Controller
@RequestMapping("/system")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/roleList")
    public String proleList() {
        return "system/role/roleList";
    }

    @GetMapping("/queryRole")
    @ResponseBody
    public List<Role> queryRole() {
        return roleService.queryRole();
    }

    /**
     * 跳转到角色授权页面
     */
    @GetMapping("toGrantAuth/{id}")
    public String toGrantAuth(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("roleId", id);
        return "/system/role/grantAuth";
    }

    @PostMapping("grantAuth")
    @ResponseBody
    @Transactional
    public ResObject grantAuth(@RequestBody Integer perIds[],Integer roleId) {
        try {
            roleService.grantAuth(roleId, perIds);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
