package com.zereight.springboot.study.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // JUnit에서 단위 테스트가 끝날 때만다 수행되는 메소드
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save( // 테이블 Posts에 insert/update 쿼리를 실행. 있으면 update 없으면 insert
                Posts.builder()
                    .title(title)
                    .content(content)
                    .author("zereight@gmail.com")
                    .build()
        );

        List<Posts> postsList = postsRepository.findAll(); // 모든값 조회

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2020, 1,13,0,0,0);

        postsRepository.save(
          Posts.builder()
                  .title("title")
                  .content("content")
                  .author("author")
                  .build()
        );

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>> createDate= "+posts.getCreatedDate()+", modifiedDate: "+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }

}
