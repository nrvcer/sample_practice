package com.nrvcer.service.impl;

import com.nrvcer.dao.UserDao;
import com.nrvcer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier(value = "userDao")
    private UserDao userDao;

    @Value(value="${jdbc.user}")
    private String username;
    @Override
    public void save() {
        System.out.println("username:" + username);
        userDao.save();
    }
}
