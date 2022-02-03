package com.example.AWS_SpringBoot.domain.posts;

import org.aspectj.lang.annotation.After;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


//해당 어노테이션 사용 시 H2데이터베이스 자동 실행.
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    //단위 테스트가 끝날 때마다 수행되는 메소드 지정.
    @AfterEach
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void getSavedPosts(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        //POSTS 테이블에 INSERT & UPDATE 실행.
        //ID있으면 UPDATE, 없으면 INSERT
        postsRepository.save(
            Posts.builder()
                    .title(title)
                    .content(content)
                    .author("jwj4016@gmail.com")
                    .build()
        );

        //when
        //POSTS 테이블에 있는 모든 데이터 조회.
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        Assertions.assertThat(posts.getTitle()).isEqualTo(title);
        Assertions.assertThat(posts.getContent()).isEqualTo(content);
    }
}
