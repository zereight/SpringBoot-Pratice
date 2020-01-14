package com.zereight.springboot.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 이것으로 인해 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정. 항상 프로젝트 최상단에 위치할 것.
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
