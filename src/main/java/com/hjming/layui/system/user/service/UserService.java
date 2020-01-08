package com.hjming.layui.system.user.service;

import com.hjming.layui.system.shrio.config.UserUtil;
import com.hjming.layui.system.user.domain.Role;
import com.hjming.layui.system.user.mapper.UserMapper;
import com.hjming.layui.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hjming
 * @version 1.0
 * @date 2020/1/7 15:35
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    public User getUserRole(Integer id) {
        return userMapper.getUserRoleById(id);
    }

    public List<Role> getRoles() {
        return userMapper.getRoles(UserUtil.getCurrentUser().getId());
    }
}
