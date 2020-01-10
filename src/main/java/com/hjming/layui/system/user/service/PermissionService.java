package com.hjming.layui.system.user.service;

import com.hjming.layui.system.shiro.config.UserUtil;
import com.hjming.layui.system.user.domain.Permission;
import com.hjming.layui.system.user.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hjming
 * @version 1.0
 * @date 2020/1/7 15:35
 */
@Service
public class PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    public List<Permission> getRolePermission(Integer roleId) {
        return permissionMapper.getRolePermission(roleId);
    }

    /**
     * 获取所有的菜单
     * @return
     */
    public List<Permission> getAllMenu() {
        List<Permission> list = permissionMapper.getAllMenu();
        List<Permission> rootPermission = new ArrayList<>();
        for (Permission info:list){
            if (info.getPid() == 0) {
                rootPermission.add(info);
            }
        }
        for (Permission info:rootPermission){
            List<Permission> childrenList= getChildrenMeun(info.getId(),list);
            info.setChildren(childrenList);
        }
        return rootPermission;
    }

    /**
     * 获取角色所有的权限（菜单）
     */
    public List<Permission> getMPermissions() {
        return permissionMapper.getMPermissions(UserUtil.getCurrentUser().getId());
    }

    /**
     * 获取角色所有权限（功能）
     */
    public List<Permission> getFPermissions() {
        return permissionMapper.getFPermissions(UserUtil.getCurrentUser().getId());
    }

    /**
     *获取所有菜单
     **/
    public List<Permission> getParentMeun() {
        //获取所有的菜单(包括子菜单和父级菜单)
        List<Permission> list = getMPermissions();
        //创建一个集合用于保存所有的主菜单
        List<Permission> rootMeun=new ArrayList<>();
        //遍历所有菜单集合,如果是主菜单的话直接放入rootMeun集合
        for (Permission info:list){
            //判断为0是因为我的主菜单标识是0
            if (info.getPid() == 0) {
                rootMeun.add(info);
            }
        }
        //这个是遍历所有主菜单,分别获取所有主菜单的所有子菜单
        for (Permission info:rootMeun){
            //获取所有子菜单 递归
            List<Permission> childrenList= getChildrenMeun(info.getId(),list);
            //这个是实体类中的子菜单集合
            info.setChildren(childrenList);
        }
        return rootMeun;
    }
    /**
     *    递归获取子菜单(这个我也不太理解，copy过去就行)
     **/
    private List<Permission> getChildrenMeun(int id, List<Permission> allMeun){
        //用于保存子菜单
        List<Permission> childrenList=new ArrayList<>();
        for (Permission info: allMeun){
            //判断当前的菜单标识是否等于主菜单的id
            if (info.getPid() == id) {
                //如果是的话 就放入主菜单对象的子菜单集合
                childrenList.add(info);
            }
        }
        //这里就是递归了，遍历所有的子菜单
        for (Permission info:childrenList){
            info.setChildren(getChildrenMeun(info.getId(),allMeun));
        }
        //如果子菜单为空的话，那就说明某菜单下没有子菜单了，直接返回空,子菜单为空的话就不会继续
        //迭代了
        if(childrenList!=null && childrenList.size()==0){
            return null;
        }
        return  childrenList;
    }

    public List<Permission> queryPermission() {
        return permissionMapper.queryAll();
    }

    public List<Permission> getPermission() {
        List<Permission> list = permissionMapper.queryAll();

        //创建一个集合用于保存所有的主菜单
        List<Permission> rootPermission = new ArrayList<>();
        //遍历所有菜单集合,如果是主菜单的话直接放入rootPermission集合
        for (Permission info:list){
            //判断为0是因为我的主菜单标识是0
            if (info.getPid() == 0) {
                rootPermission.add(info);
            }
        }
        //这个是遍历所有主菜单,分别获取所有主菜单的所有子菜单
        for (Permission info:rootPermission){
            //获取所有子菜单 递归
            List<Permission> childrenList= getChildrenMeun(info.getId(),list);
            //这个是实体类中的子菜单集合
            info.setChildren(childrenList);
        }
        return rootPermission;
    }

    public void savePermission(Permission permission) {
        permissionMapper.insert(permission);
    }
}
