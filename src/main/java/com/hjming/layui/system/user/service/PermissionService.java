package com.hjming.layui.system.user.service;

import com.hjming.layui.system.shrio.config.UserUtil;
import com.hjming.layui.system.user.domain.Permission;
import com.hjming.layui.system.user.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hjming
 * @version 1.0
 * @date 2020/1/7 15:35
 */
@Service
public class PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 获取角色所有的权限（菜单）
     */
    public List<Permission> getMPermissions() {
        return permissionMapper.getMPermissions(UserUtil.getCurrentUser().getId());
    }

    /**
     * 获取角色所有权限（功能）
     */
    public List<Permission> getFPermissions() {
        return permissionMapper.getFPermissions(UserUtil.getCurrentUser().getId());
    }

}
