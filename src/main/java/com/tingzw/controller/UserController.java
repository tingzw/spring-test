package com.tingzw.controller;

import com.tingzw.dao.UserDao;
import com.tingzw.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*import org.springframework.context.annotation.AnnotationBeanNameGenerator;*/

//import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/*import org.springframework.context.annotation.AnnotationBeanNameGenerator;*/

/*import org.springframework.context.annotation.AnnotationBeanNameGenerator;*/

/**
 * @author tingzw
 * @date 2017-01-16 14:07
 **/
@Controller
public class UserController extends AutowiredAnnotationBeanPostProcessor {

  /*  @Autowired
    private UserDao userDao;*/
  @Autowired
 /* @Qualifier("userDaoImpl_new")*/
  private UserDao userDaoImpl;

    @RequestMapping("/getUserById")
    @ResponseBody
    public String getUserById(int id) {

        User user = userDaoImpl.getUser(id);
        System.out.println(user);
        //model.addAttribute("user", user);
        return user.toString();
    }

}
