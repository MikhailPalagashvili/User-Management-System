package com.grantcs.usermanagementsystem.controller;

import com.grantcs.usermanagementsystem.GroupOrder.GroupOrder;
import com.grantcs.usermanagementsystem.domain.MUser;
import com.grantcs.usermanagementsystem.domain.SignupForm;
import com.grantcs.usermanagementsystem.service.UserApplicationService;
import com.grantcs.usermanagementsystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/signup")
@Slf4j
public class SignupController {
    private final UserApplicationService userApplicationService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public SignupController(final UserApplicationService userApplicationService,
                            final ModelMapper modelMapper,
                            final UserService userService) {
        this.userApplicationService = userApplicationService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    /**
     * Display the user signup screen
     */
    @GetMapping
    public String getSignup(final Model model, @ModelAttribute final SignupForm signupForm) {
        // Get gender
        var genderMap = userApplicationService.getGenderMap();
        model.addAttribute("genderMap", genderMap);
        // Translation to user signup screen
        return "signup/signup";
    }

    /**
     * User signup process
     */
    @PostMapping
    public String postSignup(final Model model,
                             @ModelAttribute
                             @Validated(GroupOrder.class) final SignupForm signupForm,
                             final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return getSignup(model, signupForm);
        }
        log.info(signupForm.toString());

        // Convert from MUser class
        var user = modelMapper.map(signupForm, MUser.class);
        // user signup
        userService.signup(user);
        return "redirect:/login";
    }

    /**
     * Database related exception handling
     */
    @ExceptionHandler(DataAccessException.class)
    public String dataAccessExceptionHandler(DataAccessException e, Model model) {
        // Set an empty string
        model.addAttribute("error", "");

        // Register an error in the model
        model.addAttribute("message", "An exception occurred in SignupController");

        // Register HTTP error code (500) in Model
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
        return "error";
    }

    /**
     * other exception handling
     */
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e, Model model) {
        // Set an empty string
        model.addAttribute("error", "");

        // Register an error in the model
        model.addAttribute("message", "An exception occurred in SignupController");

        // Register HTTP error code (500) in Model
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
        return "error";
    }
}
