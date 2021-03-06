package com.example.taskManyaSmriti.service;

import com.example.taskManyaSmriti.dao.UserDao;
import com.example.taskManyaSmriti.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("postgres") UserDao userDao) {
        this.userDao = userDao;
    }

    public int addUser(User user){
        return userDao.insertUser(user);
    }

    public List<User> getAllUsers(){
        return userDao.selectAllUsers();
    }

    public int searchUser(User user) {
        return userDao.searchUserDao(user);
    }
}
