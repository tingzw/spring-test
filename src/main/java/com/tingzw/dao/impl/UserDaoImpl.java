package com.tingzw.dao.impl;

import com.tingzw.dao.UserDao;
import com.tingzw.model.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

/**
 * @author tingzw
 * @date 2017-01-16 11:02
 **/
@Service
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    public User getUser(int id) {

       /* User user = new User(id, "tingzw", 30);

        return user;*/
        return this.getSqlSession().selectOne("User.getUserById", id);
    }
}
