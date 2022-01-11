package com.nrvcer.service.impl;

import com.nrvcer.dao.UserDao;
import com.nrvcer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// <bean id="userService" class="com.nrvcer.service.impl.UserServiceImpl"></bean>
//@Component(value = "userService")
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    // <property name="userDao" ref="userDao"></property>
    @Autowired
    @Qualifier(value = "userDao")
    private UserDao userDao;

    @Value(value = "${jdbc.username}")
    private String username;

    @Override
    public void save() {
        System.out.println("username:" + username);
        userDao.save();
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
