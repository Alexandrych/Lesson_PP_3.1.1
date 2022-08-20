package com.alexandrych.lesson.controller;

import com.alexandrych.lesson.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class StartPageController {

    UserService userService;

    @Autowired
    public StartPageController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsersCount(Model model) {
        model.addAttribute("count", userService.getUsersCount());
        return "index";
    }
}