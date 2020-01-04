package com.example.service;

import com.example.exception.ResourceNotFoundException;
import com.example.exception.UserHaveMadeException;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User addUser(User user) {
        Optional<Object> userDb = this.repository.findByUsername(user.getUsername());
        if(!userDb.isPresent()) {
            return this.repository.save(user);
        } else{
            throw new UserHaveMadeException("The username is used");
        }
    }

    public User updateUser(int id, User upUser) {
        Optional<User> userDb = this.repository.findById(id);

        if(userDb.isPresent()){
            User userUpdate = userDb.get();
            userUpdate.setEmail(upUser.getEmail());
            userUpdate.setName(upUser.getName());
            userUpdate.setLastName(upUser.getLastName());
            userUpdate.setPassword(upUser.getPassword());
            userUpdate.setUsername(upUser.getUsername());

            this.repository.save(userUpdate);
            return userUpdate;
        } else{
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    public User getUserById(Integer userId) {
        Optional<User> userDb = this.repository.findById(userId);

        if(userDb.isPresent()){
            return userDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + userId);
        }
    }

    public void deleteUser(Integer id) {
        Optional<User> userDb = this.repository.findById(id);

        if(userDb.isPresent()){
            this.repository.delete(userDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

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
