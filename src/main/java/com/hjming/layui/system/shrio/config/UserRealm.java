package com.hjming.layui.system.shrio.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author hjm10
 * @version 1.0
 * @date 2020-01-06 22:09
 */
public class UserRealm extends AuthorizingRealm {


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
        String username = "admin";
        String password = "admin";

        if (!username.equals(token.getPrincipal().toString())) {
            return null;
        }

        return new SimpleAuthenticationInfo(token.getPrincipal(),password,"userRealm");
    }
}
