package com.wangxu.testdemo.service;

import com.wangxu.testdemo.api.UserRepository;
import com.wangxu.testdemo.module.User;

import java.util.Optional;

public class UserService {
    public final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name,int age){
        if(name==null||name.isBlank()){
            throw new IllegalArgumentException("name required");
        }
        User user=new User(null,name,age);
        return userRepository.save(user);
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }
}
