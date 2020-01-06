package com.hjming.layui.user.controller;

import com.hjming.layui.user.dao.UserDao;
import com.hjming.layui.user.domain.User;
import com.hjming.layui.util.ResObject;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author hjming
 * @version 1.0
 * @date 2020/1/4 16:53
 */
@Controller
public class UserController {
    @Autowired
    private UserDao userDao;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("index")
    public String toUserList() {
        return "index";
    }

    @GetMapping("/userList")
    public String userList() {
        return "user/userList";
    }


    @GetMapping("/queryAllUser")
    @ResponseBody
    public List<User> queryAllUser() {
        return userDao.queryAllUser();
    }

    @GetMapping("/queryUserById")
    @ResponseBody
    public User queryUserById(String id) {
        return userDao.queryUserById(Integer.parseInt(id));
    }

    @PostMapping("/deleteUser")
    @ResponseBody
    public ResObject deleteUser(Integer[] ids) {
        try {
            for (Integer id : ids) {
                userDao.deleteUser(id);
            }
            return new ResObject(0, "删除成功");
        } catch (Exception e) {
            return new ResObject(500, "删除失败，发生以下异常：" + e.getMessage());
        }
    }

    @GetMapping("/toAddUser")
    public String toAddUser() {
        return "user/addUser";
    }

    @PostMapping("/saveUser")
    @ResponseBody
    public ResObject saveUser(@RequestBody User user) {
        try {
            userDao.saveUser(user);
            logger.info("保存成功：" + user);
            return new ResObject(200, "新增用户成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new ResObject(500, "保存发生异常：" + e.getMessage());
        }
    }

}
