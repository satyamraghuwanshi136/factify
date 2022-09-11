package com.satyam.factify.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String getHome(){
        String welcomeMessage = new String("Welcome to factify");
        return welcomeMessage;
    }

}
