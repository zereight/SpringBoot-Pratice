package com.zereight.springboot.study.springboot.web;

import com.zereight.springboot.study.springboot.service.PostsService;
import com.zereight.springboot.study.springboot.web.dto.PostsResponseDto;
import com.zereight.springboot.study.springboot.web.dto.PostsSaveRequestDto;
import com.zereight.springboot.study.springboot.web.dto.PostsUpdateRequestDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(
            @RequestBody PostsSaveRequestDto requestDto
            ){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById( @PathVariable Long id ){
        return postsService.findById(id);
    }

}
