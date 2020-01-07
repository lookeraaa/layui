package com.hjming.layui.system.shrio.config;

import com.hjming.layui.system.user.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

public class UserUtil {

	/**
	 * 获取当前用户session
	 * @return session
	 */
	public static Session getSession(){
		Session session = SecurityUtils.getSubject().getSession();
		return session;
	}
	
	/**
	 * 获取当前用户对象
	 * @return user
	 */
	public static User getCurrentUser(){
		return (User) getSession().getAttribute("user");
	}
	


}
 