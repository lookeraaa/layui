package com.hjming.layui.system.shrio.config;

import com.hjming.layui.system.user.domain.Permission;
import com.hjming.layui.system.user.domain.Role;
import com.hjming.layui.system.user.domain.User;
import com.hjming.layui.system.user.service.PermissionService;
import com.hjming.layui.system.user.service.RoleService;
import com.hjming.layui.system.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author hjm10
 * @version 1.0
 * @date 2020-01-06 22:09
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    /**
     * 授权认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //授予角色
        for (Role role : userService.getRoles()) {
            info.addRole(role.getName());
        }
        //授予权限
        List<Permission> permissions = permissionService.getFPermissions();
        for (Permission permission : permissions) {
            info.addStringPermission(permission.getPermcode());
        }

        return info;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("登录认证");
        User user = userService.getUserByUsername(token.getPrincipal().toString());
        if (user == null) {
            return null;
        }

        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("user", user);

        return new SimpleAuthenticationInfo(token.getPrincipal(),user.getPassword(),"userRealm");
    }

}
