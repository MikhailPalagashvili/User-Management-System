package com.grantcs.usermanagementsystem.controller;

import com.grantcs.usermanagementsystem.domain.UserDetailForm;
import com.grantcs.usermanagementsystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detail")
public class UserDetailController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserDetailController(final UserService userService, final ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    /**
     * Display user detail screen
     */
    @GetMapping("/{userId:.+}")
    public String getUser(UserDetailForm form, final Model model, @PathVariable("userId") final String userId) {
        // Get user
        var user = userService.getUserOne(userId);
        user.setPassword(null);
        // Get user
        form = modelMapper.map(user, UserDetailForm.class);
        form.setSalaryList(user.getSalaryList());
        // Registered in Model
        model.addAttribute("userDetailForm", form);
        // Display user details screen
        return "detail/detail";
    }

    /**
     * User update process
     */
    @PostMapping(params = "update")
    public String updateUser(UserDetailForm form, final Model model) {
        // Update user
        userService.updateUserOne(form.getUserId(), form.getPassword(), form.getUserName());
        // Redirect to user list screen
        return "redirect:/user/list";
    }

    /**
     * User delete process
     */
    @PostMapping(params = "delete")
    public String deleteUser(UserDetailForm form, final Model model) {
        // Delete user
        userService.deleteUserOne(form.getUserId());
        // Redirect to user list screen
        return "redirect:/user/list";
    }
}
