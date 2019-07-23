package com.lchy.spring_boot_junit5.controller;

import com.lchy.spring_boot_junit5.Validator.LoginValidator;
import org.springframework.http.HttpRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class HelloWorldController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody LoginValidator loginValidator, BindingResult bindingResult){
        System.out.println("+++++++++++++++++"+loginValidator.getLoginName()+"-----------------"+loginValidator.getPassword());
        return "success!";
    }
    @RequestMapping(value = "/login2")
    public String login2(LoginValidator loginValidator, BindingResult bindingResult){
        return "success2!";
    }
}
