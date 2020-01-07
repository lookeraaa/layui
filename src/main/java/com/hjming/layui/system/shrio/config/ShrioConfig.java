package com.hjming.layui.system.shrio.config;

import com.hjming.layui.system.user.domain.User;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hjm10
 * @version 1.0
 * @date 2020-01-06 22:07
 */
@Configuration
public class ShrioConfig {

    @Bean
    public FilterRegistrationBean delegatingFilterProxy(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
        proxy.setTargetFilterLifecycle(true);
        proxy.setTargetBeanName("shiroFilter");
        filterRegistrationBean.setFilter(proxy);
        return filterRegistrationBean;
    }

    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterChain = new HashMap<>();

        filterChain.put("/static/**", "anon");
        filterChain.put("/logout", "logout");
        filterChain.put("/toLogin", "anon"); //登录
        filterChain.put("/login", "anon"); //登录
        filterChain.put("/login.html", "anon"); //登录页面
        filterChain.put("/*.js", "anon");
        filterChain.put("/userList", "perms[system:manager:usermanager]");
        filterChain.put("/**", "authc");//对所有用户认证


        //登录
        filterFactoryBean.setLoginUrl("/toLogin");
        //首页
        filterFactoryBean.setSuccessUrl("/index");

        //错误页面，认证不通过跳转
        filterFactoryBean.setUnauthorizedUrl("/unAuth");
        filterFactoryBean.setFilterChainDefinitionMap(filterChain);
        return filterFactoryBean;
    }

    //权限管理，配置主要是Realm的管理认证
    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //将自己的验证方式加入容器
    @Bean(name = "userRealm")
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }
}
