package com.tingzw.dao.impl;

import com.tingzw.dao.UserDao;
import com.tingzw.model.User;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author tingzw
 * @date 2017-03-06 11:13
 **/
@Service("studentDao")
public class StudentDao implements UserDao, InitializingBean, DisposableBean {
    /**
     * Invoked by a BeanFactory on destruction of a singleton.
     *
     * @throws Exception in case of shutdown errors.
     *                   Exceptions will get logged but not rethrown to allow
     *                   other beans to release their resources too.
     */
    public void destroy() throws Exception {
        System.out.println("studentDao:destroy================");
    }

    /**
     * Invoked by a BeanFactory after it has set all bean properties supplied
     * (and satisfied BeanFactoryAware and ApplicationContextAware).
     * <p>This method allows the bean instance to perform initialization only
     * possible when all bean properties have been set and to throw an
     * exception in the event of misconfiguration.
     *
     * @throws Exception in the event of misconfiguration (such
     *                   as failure to set an essential property) or if initialization fails.
     */
    public void afterPropertiesSet() throws Exception {
        System.out.println("studentDao:afterPropertiesSet============");
    }

    public User getUser(int id) {
        return null;
    }

    //这个方法就会在Bean 初始化之后被Spring 容器执行
    @PostConstruct
    public void postConstruct(){
        System.out.println("studentDao:PostConstruct============");
    }


    //这个方法就会在Bean 初始化之后被Spring 容器执行
    @PreDestroy
    public void preDestroy(){
        System.out.println("studentDao:PreDestroy============");
    }
}
