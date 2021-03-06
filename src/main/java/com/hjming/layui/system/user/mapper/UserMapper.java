package com.hjming.layui.system.user.mapper;

import com.hjming.layui.system.user.domain.Role;
import com.hjming.layui.system.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAll();

    User getUserByUsername(String username);

    User getUserRoleById(Integer id);

    List<Role> getRoles(Integer id);
}