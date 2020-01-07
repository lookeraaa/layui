package com.hjming.layui.system.user.domain;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-07
 */
public class Rolepermission {
    /**
     * id
     */
    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleid;

    /**
     * 权限ID
     */
    private Integer permisionid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getPermisionid() {
        return permisionid;
    }

    public void setPermisionid(Integer permisionid) {
        this.permisionid = permisionid;
    }
}