package com.hjming.layui.user.dao;

import com.hjming.layui.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    List<User> queryAllUser();

    User queryUserById(Integer id);

    void saveUser(User user);

    void deleteUser(Integer id);
}
