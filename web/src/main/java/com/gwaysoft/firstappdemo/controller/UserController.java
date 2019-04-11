package com.gwaysoft.firstappdemo.controller;

import com.gwaysoft.firstappdemo.domain.User;
import com.gwaysoft.firstappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping ("/user/save")
    public User save(@RequestParam   String name){
        User user = new User();
        user.setName(name);
        user = userRepository.save(user);
        System.out.printf("User: %s save successfully ! \n", user);
        return user;
    }

    @PostMapping("/user/findAll")
    public Collection<User> findAll(){
        return userRepository.findAll();
    }
}
