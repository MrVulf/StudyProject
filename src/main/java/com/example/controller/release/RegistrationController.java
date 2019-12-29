package com.example.controller.release;

import com.example.service.UserService;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RegistrationController {

    @Autowired
    private UserService service;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("greeting",new User());
        return "registration";
    }

   @PostMapping("/registration")
   @ResponseStatus(code = HttpStatus.CREATED)
    public ModelAndView createNewUser(@RequestBody User user, BindingResult bindingResult) {

        service.checkUser(user, bindingResult);

        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            System.out.println("__________TEST ERROR__________");
            modelAndView.setViewName("/registration");
        } else {
            System.out.println("__________TEST MAKING__________");
            service.addUser(user);

            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");
        }

        return modelAndView;
    }
}
