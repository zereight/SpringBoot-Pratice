package com.zereight.springboot.study.springboot.service;

import com.zereight.springboot.study.springboot.domain.posts.Posts;
import com.zereight.springboot.study.springboot.domain.posts.PostsRepository;
import com.zereight.springboot.study.springboot.web.dto.PostsResponseDto;
import com.zereight.springboot.study.springboot.web.dto.PostsSaveRequestDto;
import com.zereight.springboot.study.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("해당 사용자가 없습니다. id="+id) );

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id) );
        return new PostsResponseDto(entity);
    }

}
