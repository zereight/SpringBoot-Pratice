package com.zereight.springboot.study.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void lombok_test(){

        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name); // 검증하고 싶은 대상을 메소드 인자로 줍니다.
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}
