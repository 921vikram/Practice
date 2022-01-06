package com.annotations.spring_boot_annotations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @ResponseBody
    public String getHome() {
        System.out.println("this is home method");
        return "this is my home";
    }
}
