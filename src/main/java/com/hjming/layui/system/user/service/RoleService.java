package com.hjming.layui.system.user.service;

import com.hjming.layui.system.user.domain.Role;
import com.hjming.layui.system.user.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author hjming
 * @version 1.0
 * @date 2020/1/7 15:35
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePermissionService rolePermissionService;

    public Role getRolePermission(Integer id) {
        return roleMapper.getRolePermission(id);
    }

    public List<Role> queryRole() {
        return roleMapper.selectAllRole();
    }

    /**
     * 授权
     * @param roleId 角色id
     * @param perIds 权限ids[]
     */
    public void grantAuth(Integer roleId, Integer[] perIds) {
        for (Integer perId : perIds) {
            rolePermissionService.deleteRolePermission(roleId);

            rolePermissionService.grantAuth(roleId, perId);
        }
    }
}
