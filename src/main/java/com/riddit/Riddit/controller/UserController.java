package com.riddit.Riddit.controller;

import com.riddit.Riddit.model.User;
import com.riddit.Riddit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // TODO: Remove after user class is completed, this is just to develop purposes
    @RequestMapping("/user")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // TODO: Add password size verification
    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    // TODO: Make a way to update the email, as the email is the id
    @RequestMapping(method = RequestMethod.PUT, value = "/user")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }
}