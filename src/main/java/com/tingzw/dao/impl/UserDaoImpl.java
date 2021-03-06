package com.tingzw.dao.impl;

import com.tingzw.dao.UserDao;
import com.tingzw.model.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.core.annotation.Order;
import org.springframework.session.web.http.SessionRepositoryFilter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author tingzw
 * @date 2017-01-16 11:02
 **/
@Order(SessionRepositoryFilter.DEFAULT_ORDER)
@Service
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    public User getUser(int id) {

       /* User user = new User(id, "tingzw", 30);

        return user;*/
        return this.getSqlSession().selectOne("User.getUserById", id);
    }

    //这个方法就会在Bean 初始化之后被Spring 容器执行
    @PostConstruct
    public void postConstruct(){
        System.out.println("UserDaoImpl----PostConstruct");
    }


    //这个方法就会在Bean 初始化之后被Spring 容器执行
    @PreDestroy
    public void preDestroy(){
        System.out.println("UserDaoImpl----PreDestroy");
    }
}
