package com.example.taskManyaSmriti.dao;

import com.example.taskManyaSmriti.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDaoRepository {

    int insertUser(UUID id, User user);

    default int insertUser(User user){
        UUID id = UUID.randomUUID();
        return insertUser(id,user);
    }

    //Retrieve - GET Req
    List<User> selectAllUsers();

    int searchUserDao(User user);
}
