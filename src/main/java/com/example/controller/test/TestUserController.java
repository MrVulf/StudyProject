package com.example.controller.test;


import com.example.service.UserService;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/test/user")
public class TestUserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/get_user")
    @ResponseStatus(code = HttpStatus.FOUND)
    @ResponseBody
    public User getUser(@RequestParam int id){
        return service.getUserById(id);
    }

    @PostMapping("/add_user")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<User> addUser (@RequestBody User user){
        return ResponseEntity.ok(service.addUser(user));
    }

    @PutMapping("/improve_user/{id}")
    public ResponseEntity<User> replaceContact(@PathVariable int id, @RequestBody User user){ // id из пути
        User repUser = service.updateUser(id, user);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(repUser);
        }
    }

    @DeleteMapping("/delete_user")
    public void deleteUser(@RequestParam int id){
        service.deleteUser(id);
    }
}
