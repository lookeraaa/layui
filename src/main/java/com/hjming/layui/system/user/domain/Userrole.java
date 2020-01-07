package com.hjming.layui.system.user.domain;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-07
 */
public class Userrole {
    /**
     * id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userid;

    /**
     * 角色ID
     */
    private Integer roleid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}