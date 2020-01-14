package com.zereight.springboot.study.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class) // 테스트를 진행할때 JUnit에 내장된 실행자 외에 다른 실행자(SpringbootRunner)를 실행
@WebMvcTest // Web(Spring MVC)에 집중할 수 있게 해주는 어노테이션.
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 Bean을 주입받는다.
    private MockMvc mvc; // 웹 API를 테스트할때 사용한다. 이걸로 get,post에 대한 API테스트 가능

    @Test
    public void return_hello() throws Exception{
        String hello = "hello";
        mvc.perform(MockMvcRequestBuilders.get("/hello")) // /hello 주소로 get요청
                .andExpect(MockMvcResultMatchers.status().isOk()) // ok, 즉 200인지 체크
                .andExpect(MockMvcResultMatchers.content().string("hello")); // 응답 본문의 내용이 hello인지 검증
    }

}
