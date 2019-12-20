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
    public User addUser(User user) {
        return this.repository.save(user);
    }

    @Override
    public User updateUser(int id, User upUser) {
        Optional<User> userDb = this.repository.findById(id);

        if(userDb.isPresent()){
            User userUpdate = userDb.get();
            userUpdate.setId(upUser.getId());
            userUpdate.setEmail(upUser.getEmail());
            userUpdate.setName(upUser.getName());
            userUpdate.setLastName(upUser.getLastName());
            userUpdate.setPassword(upUser.getPassword());
            userUpdate.setUsername(upUser.getUsername());

            this.repository.save(userUpdate);
            return  userUpdate;
        } else{
            throw new ResourceNotFoundException("Record not found with id : " + id);
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
