package com.hjming.layui.system.user.domain;

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
}