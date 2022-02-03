package com.example.AWS_SpringBoot.web;

//import org.junit.Test;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//JUnit에 내장된 실행자 외 다른 실행자(SpringRunner) 실행.
//@RunWith(SpringRunner.class)
//@WebMvcTest 선언 시, @Controller, @ControllerAdivce 사용 가능
//@Service, @Component, @Repository 등은 사용 불가
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    //웹 api 테스트 시 사용.
    //스프링 mvc테스트의 시작점.
    //http get,post 등에 대한 api 테스트 가능
    private MockMvc mvc;

    @Test
    public void returnHello() throws Exception{
        String hello = "hello";

        //MockMvc를 통해 get request.
        mvc.perform(MockMvcRequestBuilders.get("/hello"))
                //perform()의 결과 검증.
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(hello));
    }

    @Test
    public void returnHelloDto() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(MockMvcRequestBuilders.get("/hello/dto")
                                          .param("name",name)
                                          .param("amount", String.valueOf(amount)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is(name)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.amount", Matchers.is(amount)));


    }
}
