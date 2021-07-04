package com.grantcs.usermanagementsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/logout")
@Controller
@Slf4j
public class LogoutController {
    @PostMapping
    public String postLogout() {
        log.info("Logout");
        return "redirect:/login";
    }
}
