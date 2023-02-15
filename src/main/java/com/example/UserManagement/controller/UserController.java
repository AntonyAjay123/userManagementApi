package com.example.UserManagement.controller;

import com.example.UserManagement.model.User;
import com.example.UserManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usermanagement")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers(){
       return userService.getAllUsers();
    }
    @GetMapping("/id")
    public User getUserById(@RequestParam int id){
        return userService.getUserById(id);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        userService.postUser(user);
    }

    @PutMapping("/updateUser")
    public void updateUserInfo(@RequestParam int id,@RequestBody User user){
        userService.updateUser(id,user);
    }

    @DeleteMapping("/deleteId")
    public void deleteUser(@RequestParam int id){
        userService.deleteUser(id);
    }
}
