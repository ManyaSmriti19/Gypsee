package com.example.taskManyaSmriti.dao;

import com.example.taskManyaSmriti.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("postgres")
public class UserDao implements UserDaoRepository{

    // hoax database
    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id,user.getName(), user.getEmail(), user.getPassword()));
        return 1;
    }

    @Override
    public List<User> selectAllUsers(){
        return DB;
    }

    @Override
    public int searchUserDao(User user) {
        User loginUserWithEmail = DB.stream().filter(customer -> user.getEmail().equals(customer.getEmail()))
                .findAny()
                .orElse(null);
        User loginUserWithName = DB.stream().filter(customer -> user.getName().equals(customer.getName()))
                .findAny()
                .orElse(null);
        if(loginUserWithEmail.getPassword() == user.getPassword() || loginUserWithName.getPassword() == user.getPassword())
            return 1;
        return 0;
    }

}
