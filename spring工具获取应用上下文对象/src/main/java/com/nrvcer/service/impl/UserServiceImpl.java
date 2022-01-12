package com.nrvcer.service.impl;

import com.nrvcer.dao.UserDao;
import com.nrvcer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier(value = "userDao")
    private UserDao userDao;
    @Override
    public void save() {
        userDao.save();
    }
}
