package com.transaction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String Home() {
        return "Hello home";
    }

    @GetMapping("/user")
    public String User() {
        return "Hello user";
    }

    @GetMapping("/admin")
    public String Admin() {
        return "Hello admin";
    }
}
