package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    public User createUser(String username, String password){
        User newuser = new User();
        newuser.setUsername(username);
        newuser.setPassword(password);
        newuser.setFirstName("test");
        newuser.setLastName("test");

        userRepository3.save(newuser);
        return newuser;
    }

    public void deleteUser(int userId){
        userRepository3.deleteById(userId);
    }

    public User updateUser(Integer id, String password){
        User user = userRepository3.findById(id).get();
        user.setPassword(password);
        userRepository3.save(user);
        return user;
    }
}
