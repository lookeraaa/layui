package com.hjming.layui.system.user.mapper;

import com.hjming.layui.system.user.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<Permission> getMPermissions(Integer id);

    List<Permission> getFPermissions(Integer id);

    List<Permission> queryAll();

    /**
     * 获取所有菜单
     */
    List<Permission> getAllMenu();

    /**
     * 获取roleId的所有权限
     */
    List<Permission> getRolePermission(Integer roleId);
}