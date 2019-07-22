package com.lchy.spring_boot_junit5.controller;

//import org.junit.Test;
import com.lchy.spring_boot_junit5.Validator.LoginValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class HelloWorldControllerTest {

    @Autowired
    HelloWorldController helloWorldController;

    @Test
    void login() {
        LoginValidator loginValidator = new LoginValidator();
        loginValidator.setPassword("123");
        loginValidator.setLoginName("hello");
        String resStr = helloWorldController.login(loginValidator,null);
        assertEquals("success!",resStr);
    }
}