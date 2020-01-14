package com.zereight.springboot.study.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// Entity 클래스는 기본 Repository 없이는 제대로 역할을 할 수 없다! 그래서 같은 패키지 안에서 관리
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
