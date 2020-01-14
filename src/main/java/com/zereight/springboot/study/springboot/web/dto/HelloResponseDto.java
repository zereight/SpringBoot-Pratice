package com.zereight.springboot.study.springboot.web.dto;

import lombok.Getter; // 책에서 나오듯이 플러그인 추가 해주기
import lombok.RequiredArgsConstructor;

@Getter // 선언된 모든 필드의 get 메소드를 생성해준다.
@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 생성자를 생성해준다. (final 안붙어있으면 포함x)
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
