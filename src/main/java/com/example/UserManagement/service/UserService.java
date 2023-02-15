package com.example.UserManagement.service;

import com.example.UserManagement.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserService {

    static List<User> users=new ArrayList<>();
    static int userCount=0;
    static{
        users.add(new User(++userCount,"Ajay","Glitch","57,BDS Nagar","9901340283"));
        users.add(new User(++userCount,"Xyz","Xyz","57,BDS","99012"));
        users.add(new User(++userCount,"Abc","abc_012","57,abcr","40283"));
    }

    public List<User> getAllUsers(){
        return users;
    }
    public User getUserById(int id){
        for(User u:users){
            if(u.getUserId()==id)
                return u;
        }
        return new User(id,"No such User","No such user","No address","No phone");
    }

    public void postUser(User user){
        users.add(user);
    }

    public void deleteUser(int id){
        Predicate<?super User> predicate = user -> user.getUserId()==id;
        users.removeIf(predicate);
    }

    public void updateUser(int id,User newUser){
        User user = getUserById(id);
        user.setUserId(newUser.getUserId());
        user.setUserName(newUser.getUserName());
        user.setAddress(newUser.getAddress());
        user.setName(newUser.getName());
        user.setPhNumber(newUser.getPhNumber());
    }
}
