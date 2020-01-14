package com.zereight.springboot.study.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
* 자바빈 규약을 생각하면서 getter/setter를 무작정 생성하는 경우가 있는데,
* 그렇게 하면 해당 클래스의 인스턴스 값들이 언제 어디서 변해야 하는지 코드상으로 명확하게 구분할 수가 없어,
* 차후 기능 변경 시 정말 복잡해 지므로,
*
* Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다.
* 변경하려면 목적이 드러나는 메소드로 선언한다.
* */


@Getter // lombok 기능
@NoArgsConstructor // 기본 생성자를 자동으로 추가함.
@Entity // 테이블과 링크될 클래스 임을 나타냄.
public class Posts {

    @Id // 해당 필드의 PK(기본키) 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙을 나타냄. Identity여야 auto increment됨.
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 컬럼을 나타내며, 굳이 선언안해도 Entity클래스 내의 필드는 모두 컬럼이 됨.
    // CreateDatabase 할때 attr의 조건 정해주는거랑 비슷한 효과를 지님
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // lombok 기능으로서 해당 클래스의 빌더 패턴 클래스를 생성한다.
    // 생성자 상단에 선언하면 (지금처럼) 생성자에 포함된 필드만 빌더에 포함시킨다.
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
