package com.alexandrych.lesson.dao;

import com.alexandrych.lesson.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {
}
