package com.example.controller;

import com.example.impl.UserServiceImpl;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserServiceImpl service;

    @Autowired
    public RegistrationController(UserServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String  registration(Model model) {
        model.addAttribute("greeting",new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {

        service.checkUser(user, bindingResult);

        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            System.out.println("__________TEST__________");
            modelAndView.setViewName("/registration");
        } else {
            service.createUser(user);

            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("/registration");
        }

        return modelAndView;
    }
}
