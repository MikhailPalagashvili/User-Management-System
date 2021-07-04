package com.grantcs.usermanagementsystem.controller;

import com.grantcs.usermanagementsystem.domain.MUser;
import com.grantcs.usermanagementsystem.domain.UserListForm;
import com.grantcs.usermanagementsystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/list")
public class UserListController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserListController(final UserService userService,
                              final ModelMapper modelMapper) {

        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    /**
     * Display user list screen
     */
    @GetMapping
    public String getUserList(@ModelAttribute final UserListForm form,
                              final Model model) {

        // Convert form to MUser class
        final var user = modelMapper.map(form, MUser.class);
        // Get user list
        final var userList = userService.getUsers(user);
        // Registered in Model
        model.addAttribute("userList", userList);
        // Get user screen
        return "list/list";
    }

    /**
     * User search process
     */
    @PostMapping
    public String postUserList(@ModelAttribute UserListForm form,
                               final Model model) {

        // Convert form to MUser class
        final var user = modelMapper.map(form, MUser.class);
        // Get user list
        final var userList = userService.getUsers(user);
        // Registered in Model
        model.addAttribute("userList", userList);
        // Get user screen
        return "list/list";
    }
}
