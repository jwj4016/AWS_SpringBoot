package com.example.AWS_SpringBoot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//아래 어노테이션을 추가하지 않아도 된다.
//entity 클래스와 repository interface는 동일 위치에 있어야한다.
//@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
