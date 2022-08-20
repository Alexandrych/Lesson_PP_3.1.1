package com.alexandrych.lesson.service;

import com.alexandrych.lesson.dao.UserDao;
import com.alexandrych.lesson.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl (UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public long getUsersCount() {
        return userDao.count();
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userDao.findAll().forEach(users::add);
        return users;
    }

    @Override
    @Transactional
    public String addUser(User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users";
        }
        userDao.save(user);
        return "redirect:/users";
    }

    @Override
    @Transactional
    public String updateUser(User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userDao.save(user);
        return "redirect:/users";
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        userDao.deleteById(id);
    }

    @Override
    public User getUserByID(long id) {
        return userDao.findById(id).get();
    }

}
