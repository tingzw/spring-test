package com.tingzw.dao.impl;

import com.tingzw.dao.UserDao;
import com.tingzw.model.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author tingzw
 * @date 2017-02-08 16:06
 **/
@Service
public class UserDaoImpl_new  extends SqlSessionDaoSupport implements UserDao {

    public User getUser(int id) {

       /* User user = new User(id, "tingzw", 30);

        return user;*/
        return this.getSqlSession().selectOne("User.getUserById", id);
    }

    //这个方法就会在Bean 初始化之后被Spring 容器执行
    @PostConstruct
    public void postConstruct(){
        System.out.println("UserDaoImpl_new----PostConstruct");
    }


    //这个方法就会在Bean 初始化之后被Spring 容器执行
    @PreDestroy
    public void preDestroy(){
        System.out.println("UserDaoImpl_new----PreDestroy");
    }
}
