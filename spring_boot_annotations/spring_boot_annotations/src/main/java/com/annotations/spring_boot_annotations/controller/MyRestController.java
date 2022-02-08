package com.annotations.spring_boot_annotations.controller;

import com.annotations.spring_boot_annotations.model.User;
import com.annotations.spring_boot_annotations.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
public class MyRestController {

    @Autowired
    UserService userService;

    @GetMapping(
        path = {"/users"},
        produces = "application/json;charset=UTF-8")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/users/{name}")
    public void deleteUser(@PathVariable("name") String name) {
        userService.delete(name);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getHome() {
        System.out.println("this is home method");
        return "this is my home";
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public String getUser(@PathVariable("userId") String st) {
        System.out.println("print "+st);
        return "user";
    }

}
