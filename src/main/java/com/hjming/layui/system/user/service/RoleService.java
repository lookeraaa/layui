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

    public Role getRolePermission(Integer id) {
        return roleMapper.getRolePermission(id);
    }

    public List<Role> queryRole() {
        return roleMapper.selectAllRole();
    }
}
