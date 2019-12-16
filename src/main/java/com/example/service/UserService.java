package com.example.service;

import com.example.model.User;
import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    User getUserById(Integer userId);
    void deleteUser(Integer id);
}
