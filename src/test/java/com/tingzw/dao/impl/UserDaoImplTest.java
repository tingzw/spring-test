package com.tingzw.dao.impl;

import com.tingzw.dao.UserDao;
import com.tingzw.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author tingzw
 * @date 2017-01-16 11:16
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class UserDaoImplTest {
    @Resource
    private UserDao userDao;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetUser() throws Exception {
        for (int i = 0; i < 10; i++) {
            User user = userDao.getUser(16);
            System.out.println(user);
        }

    }

}