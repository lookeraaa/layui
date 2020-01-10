package com.hjming.layui.system.user.service;

import com.hjming.layui.system.user.domain.Role;
import com.hjming.layui.system.user.mapper.RolepermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hjming
 * @version 1.0
 * @date 2020/1/7 15:35
 */
@Service
public class RolePermissionService {

    @Autowired
    private RolepermissionMapper rolepermissionMapper;

    public void deleteRolePermission(Integer roleId) {
        rolepermissionMapper.deleteRolePermission(roleId);
    }

    public void grantAuth(Integer roleId, Integer perId) {
        rolepermissionMapper.grantAuth(roleId, perId);
    }
}
