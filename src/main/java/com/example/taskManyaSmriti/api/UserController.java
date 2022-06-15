package com.example.taskManyaSmriti.api;

import com.example.taskManyaSmriti.model.User;
import com.example.taskManyaSmriti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/users")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@NonNull User user){
        userService.addUser(user);
    }

    @PostMapping(path = "/login")
    public void searchUser(@NonNull User user){
        userService.searchUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
