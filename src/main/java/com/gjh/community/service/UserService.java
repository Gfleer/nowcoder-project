package com.gjh.community.service;

import com.gjh.community.dao.UserDao;
import com.gjh.community.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public User selectById(int userId){
        return userDao.selectById(userId);
    }

}
