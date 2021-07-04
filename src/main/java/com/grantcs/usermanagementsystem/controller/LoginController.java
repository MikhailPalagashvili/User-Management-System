package com.grantcs.usermanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "/login"})
public class LoginController {
    /**
     * Display Login Screen
     */
    @GetMapping
    public String getLogin() {
        return "login/login";
    }

    /**
     * Redirect to user list screen
     */
    @PostMapping
    public String postLogin() {
        return "redirect:/user/list";
    }
}
