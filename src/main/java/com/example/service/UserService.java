package com.example.service;

import com.example.model.User;
import org.springframework.validation.BindingResult;


public interface UserService {
    User addUser(User user);
    User updateUser(int id, User upUser);
    User getUserById(Integer userId);
    void deleteUser(Integer id);

    void checkUser(User user, BindingResult bindingResult);
}
