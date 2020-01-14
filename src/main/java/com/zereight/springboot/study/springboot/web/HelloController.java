package com.zereight.springboot.study.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 일반 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어준다.
public class HelloController {
    @GetMapping("/hello") // http의 get의 요청을 받을 수 있는 API를 만들어준다.
    public String hello(){
        return "hello";
    }
}
