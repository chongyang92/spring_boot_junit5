package com.lchy.spring_boot_junit5.controller;

import com.lchy.spring_boot_junit5.Validator.LoginValidator;
import org.springframework.http.HttpRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class HelloWorldController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(LoginValidator loginValidator, BindingResult bindingResult){
        return "success!";
    }
    @RequestMapping(value = "/login2")
    public String login2(LoginValidator loginValidator, BindingResult bindingResult){
        return "success2!";
    }
}
