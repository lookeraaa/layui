package com.hjming.layui.system.shrio.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hjm10
 * @version 1.0
 * @date 2020-01-06 22:07
 */
@Configuration
public class ShrioConfig {

    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> map = new HashMap<>();

        map.put("/logout", "logout");
        map.put("/toLogin", "anon"); //登录
        map.put("/login.html", "anon"); //登录页面
        map.put("/layui/**", "anon"); //登录页面
        map.put("/**", "authc");//对所有用户认证

        //登录
        filterFactoryBean.setLoginUrl("/toLogin");
        //首页
        filterFactoryBean.setSuccessUrl("/index");
        //错误页面，认证不通过跳转
        filterFactoryBean.setUnauthorizedUrl("/toLogin");
        filterFactoryBean.setFilterChainDefinitionMap(map);
        return filterFactoryBean;
    }

    //权限管理，配置主要是Realm的管理认证
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    //将自己的验证方式加入容器
    @Bean
    public UserRealm myShiroRealm() {
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }
}
