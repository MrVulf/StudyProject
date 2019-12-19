package com.example.impl;

import com.example.exception.ResourceNotFoundException;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User createUser(User user) {
        return this.repository.save(user);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> userDb = this.repository.findById(user.getId());

        if(userDb.isPresent()){
            User userUpdate = userDb.get();
            userUpdate.setId(user.getId());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setName(user.getName());
            userUpdate.setLastName(user.getLastName());
            userUpdate.setPassword(user.getPassword());
            userUpdate.setUsername(user.getUsername());

            this.repository.save(userUpdate);
            return  userUpdate;
        } else{
            throw new ResourceNotFoundException("Record not found with id : " + user.getId());
        }
    }

    @Override
    public User getUserById(Integer userId) {
        Optional<User> userDb = this.repository.findById(userId);

        if(userDb.isPresent()){
            return userDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + userId);
        }
    }

    @Override
    public void deleteUser(Integer id) {
        Optional<User> userDb = this.repository.findById(id);

        if(userDb.isPresent()){
            this.repository.delete(userDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    @Override
    public void checkUser(User user, BindingResult bindingResult) {
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (repository.findByUsername(user.getUsername()).isPresent()) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "There is already a user registered with the username provided");
        }
    }
}
