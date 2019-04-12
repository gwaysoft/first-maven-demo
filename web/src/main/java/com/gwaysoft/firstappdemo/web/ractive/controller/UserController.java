package com.gwaysoft.firstappdemo.web.ractive.controller;

import com.gwaysoft.firstappdemo.web.ractive.domain.User;
import com.gwaysoft.firstappdemo.web.ractive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostMapping ("/user/save")
    public User save(@RequestParam   String name){
        User user = new User();
        user.setName(name);
        user = userRepository.save(user);
        System.out.printf("User: %s save successfully ! \n", user);
        return user;
    }

    @PostMapping("/user/findAll")
    public Iterable<User> findAll(){
        return userRepository.findAll();
    }


    @PostMapping("/showJdbc")
    public List<Map<String, Object>> showJdbc(){
       return jdbcTemplate.queryForList("select * from user");
    }

}
