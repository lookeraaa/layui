package com.hjming.layui.system.user.controller;

import com.hjming.layui.system.shiro.config.UserUtil;
import com.hjming.layui.system.user.domain.Permission;
import com.hjming.layui.system.user.domain.User;
import com.hjming.layui.system.user.mapper.PermissionMapper;
import com.hjming.layui.system.user.mapper.UserMapper;
import com.hjming.layui.system.user.service.PermissionService;
import com.hjming.layui.util.ResObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    Logger logger = LoggerFactory.getLogger(PermissionController.class);

    /**
     * 跳转到权限管理页面
     *
     * @return
     */
    @GetMapping("/permissionList")
    public String permissionList() {
        return "system/permission/permissionList";
    }


    /**
     * 跳转到添加权限
     *
     * @param id
     * @return
     */
    @GetMapping("toAddPermission")
    public String toAddPermission(Integer id, Model model) {
        return "system/permission/addPermission";
    }


    /**
     * 获取当前用户的菜单
     *
     * @return
     */
    @GetMapping("getMenu")
    @ResponseBody
    public List<Permission> getMenu() {
        return permissionService.getParentMeun();
    }

    /**
     * 获取所有的权限和菜单
     *
     * @return
     */
    @GetMapping("getPermission")
    @ResponseBody
    public List<Permission> getPermission() {
        return permissionService.getPermission();
    }

    /**
     * 获取选中角色的所有权限
     *
     * @return
     */
    @GetMapping("getRolePermission")
    @ResponseBody
    public List<Permission> getRolePermission(Integer roleId) {
        return permissionService.getRolePermission(roleId);
    }

    /**
     * 获取所有的菜单
     *
     * @return
     */
    @GetMapping("/getAllMenu")
    @ResponseBody
    public List<Permission> getAllMenu() {
        return permissionService.getAllMenu();
    }

    @PostMapping("/savePermission")
    @ResponseBody
    public ResObject savePermission(Permission permission) {
        try {
            if (permission == null) {
                return new ResObject(500, "输入为空");
            }
            if (permission.getPid() == null) {
                permission.setPid(0);
            }
            permissionService.savePermission(permission);
            return new ResObject(200, "添加成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResObject(500, "保存发生异常：" + e.getMessage());
        }
    }


}
