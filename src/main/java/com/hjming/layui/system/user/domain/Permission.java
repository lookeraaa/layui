package com.hjming.layui.system.user.domain;

import java.util.List;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-07
 */
public class Permission {
    /**
     * id
     */
    private Integer id;

    /**
     * 父id
     */
    private Integer pid;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限编码
     */
    private String permcode;

    /**
     * 权限类型：1：菜单 0：功能
     */
    private Integer type;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 菜单的url地址
     */
    private String url;

    /**
     * 描述
     */
    private String description;
    /**
     * 子菜单集合
     */
    private List<Permission> children;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPermcode() {
        return permcode;
    }

    public void setPermcode(String permcode) {
        this.permcode = permcode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public List<Permission> getChildren() {
        return children;
    }

    public void setChildren(List<Permission> children) {
        this.children = children;
    }
}