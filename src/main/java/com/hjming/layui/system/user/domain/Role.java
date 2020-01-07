package com.hjming.layui.system.user.domain;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-07
 */
public class Role {
    /**
     * id
     */
    private Integer id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色编码
     */
    private String rolecode;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序
     */
    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}