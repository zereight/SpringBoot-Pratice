package com.zereight.springboot.study.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 createDate, LocalDateTime 필드를 상속하게 함
@EntityListeners(AuditingEntityListener.class) // BaseTimeEntity에 Auditing 기능을 포함시킴.
public abstract class BaseTimeEntity { // 모든 Entity의 상위 클래스가 되어서 Entity들의 createdDate, modifiedDate를 자동으로 관리하는 역할을 함.

    @CreatedDate // Entity가 생성되어 저장될 떄 시간이 자동 저장됨.
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 Entity의 값을 변경할 때 자동으로 시간 저장하게 함
    private LocalDateTime modifiedDate;

}
