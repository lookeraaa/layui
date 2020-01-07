package com.hjming.layui.system.shrio.config;

import com.hjming.layui.system.user.domain.User;
import com.hjming.layui.system.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hjm10
 * @version 1.0
 * @date 2020-01-06 22:09
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    /**
     * 授权认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("登录认证");
        User user = userService.getUserByUsername(token.getPrincipal().toString());

        if (!user.getUsername().equals(token.getPrincipal().toString())) {
            return null;
        }

        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("user", user);

        return new SimpleAuthenticationInfo(token.getPrincipal(),user.getPassword(),"userRealm");
    }

}
