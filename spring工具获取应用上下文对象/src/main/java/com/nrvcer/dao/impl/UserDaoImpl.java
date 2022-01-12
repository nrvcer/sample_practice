package com.nrvcer.dao.impl;

import com.nrvcer.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save running!");
    }
}
