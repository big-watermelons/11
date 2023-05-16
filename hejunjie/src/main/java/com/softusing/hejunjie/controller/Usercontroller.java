package com.softusing.hejunjie.controller;

import com.softusing.hejunjie.entity.User;
import com.softusing.hejunjie.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class Usercontroller {

    private UserRepository userRepository;

    @GetMapping("/hello")
    public String sayhello() {
        return "hello!";
    }


    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List<User> getAllUser() {
//        List<User> userlist = new ArrayList<>();
//        User user1 = new User();
//        user1.setName("tokyo");
//        user1.setAge(30);
//        user1.setId(001);
//
//
//        User user2 = new User();
//        user2.setName("osaka");
//        user2.setAge(31);
//        user2.setId(002);
//
//        userlist.add(user1);
//        userlist.add(user2);


//        return userlist;
        return userRepository.findAll();
    }
//
//    @PostMapping("/users") {
//        public void addUser (@RequestBody User user){
//            userRepository.save(user);
//        }
    }




