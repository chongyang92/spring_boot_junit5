package com.lchy.spring_boot_junit5.controller;

//import org.junit.Test;
import com.alibaba.fastjson.JSON;
import com.lchy.spring_boot_junit5.Validator.LoginValidator;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    HelloWorldController helloWorldController;

    @Test
    void login() throws Exception {

        LoginValidator loginValidator = new LoginValidator();
        loginValidator.setPassword("123");
        loginValidator.setLoginName("hello");
        String resStr = helloWorldController.login(loginValidator,null);
        assertEquals("success!",resStr);
    }

    @Test
    void login2() throws Exception {
        LoginValidator loginValidator = new LoginValidator();
        loginValidator.setLoginName("aaa");
        loginValidator.setPassword("bbb");
        //String requestJson = JSONObject.toJSONString(loginValidator);
        String requestJson = JSON.toJSONString(loginValidator);
        //JSON.parseObject(loginValidator.toString(),LoginValidator.class);
        String url="/login/login";
        //requestJson = "\"loginName\":\"aaa\",\"password\":\"bbb\"";
        String responseString = mockMvc.perform( post(url).contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson)).andDo(print())
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println("--------返回的json = " + responseString);
    }


}