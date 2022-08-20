package com.alexandrych.lesson.service;

import com.alexandrych.lesson.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.List;

@Component
public interface UserService {
    long getUsersCount();
    List<User> getUsers();
    String addUser(User user, BindingResult bindingResult);
    String updateUser(User user, BindingResult bindingResult);
    void deleteUserById(long id);
    User getUserByID(long id);
}
