package com.zereight.springboot.study.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class) // 테스트를 진행할때 JUnit에 내장된 실행자 외에 다른 실행자(SpringbootRunner)를 실행
@WebMvcTest // Web(Spring MVC)에 집중할 수 있게 해주는 어노테이션.
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 Bean을 주입받는다.
    private MockMvc mvc; // 웹 API를 테스트할때 사용한다. 이걸로 get,post에 대한 API테스트 가능

    @Test
    public void return_hello() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello")) // /hello 주소로 get요청
                .andExpect(status().isOk()) // ok, 즉 200인지 체크
                .andExpect(content().string("hello")); // 응답 본문의 내용이 hello인지 검증
    }

    @Test
    public void return_helloDto() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform( get("/hello/dto")
                                        .param("name", name) // @param은 API를 테스트할때 사용될 요청 파라미터 설정(값은 String 만 허용)
                                        .param("amount", String.valueOf(amount))
        )
                .andExpect( status().isOk() )
                .andExpect( jsonPath("$.name", is(name)) ) // jsonPath는 JSON응답값을 필드별로 검증가능
                .andExpect( jsonPath("$.amount", is(amount)) ); // $. 를 기준으로 필드명 명시

    }

}
