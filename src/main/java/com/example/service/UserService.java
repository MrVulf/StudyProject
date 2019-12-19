package com.example.service;

import com.example.model.User;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    User getUserById(Integer userId);
    void deleteUser(Integer id);

    void checkUser(User user, BindingResult bindingResult);
}
