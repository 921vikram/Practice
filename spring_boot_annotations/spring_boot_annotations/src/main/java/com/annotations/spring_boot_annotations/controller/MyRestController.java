package com.annotations.spring_boot_annotations.controller;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
public class MyRestController {


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
