package com.nrvcer.dao.impl;

import com.nrvcer.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// <bean id="userDao" class="com.nrvcer.dao.impl.UserDaoImpl"></bean>
//@Component(value = "userDao")
@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save running!");
    }
}
