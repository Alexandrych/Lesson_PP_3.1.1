package com.alexandrych.lesson.controller;

import com.alexandrych.lesson.model.User;
import com.alexandrych.lesson.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("usersList", userService.getUsers());
        model.addAttribute("modelUser", new User());
        return "users";
    }

    @PostMapping
    public String addUser(@ModelAttribute("modelUser") @Valid User user,
                          BindingResult bindingResult,
                          Model model) {
        model.addAttribute("usersList", userService.getUsers());
        return userService.addUser(user, bindingResult);
    }

    @PostMapping("/{id}/delete")
    public String deleteUserById(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUserByID(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserByID(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        return userService.updateUser(user, bindingResult);
    }
}
