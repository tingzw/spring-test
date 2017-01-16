package com.tingzw.controller;

import com.tingzw.dao.UserDao;
import com.tingzw.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author tingzw
 * @date 2017-01-16 14:07
 **/
@Controller
public class UserController {
    @Resource
    private UserDao userDao;

    @RequestMapping("/getUserById")
    @ResponseBody
    public String getUserById(int id) {
        User user = userDao.getUser(id);
        System.out.println(user);
        //model.addAttribute("user", user);
        return user.toString();
    }
}
