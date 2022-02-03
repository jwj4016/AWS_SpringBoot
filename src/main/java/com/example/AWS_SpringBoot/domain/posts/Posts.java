package com.example.AWS_SpringBoot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Entity 클래스에서는 절대 Setter를 만들지 않음.
//필드값 변경이 필요할 경우 method를 추가해야한다.
@Getter
//기본 생성자 자동 추가
//public Posts(){}와 같은 효과.
@NoArgsConstructor
//테이블과 링크될 클래스임을 나타냄.
@Entity
public class Posts {

    //해당 테이블의 PK필드를 나타냄.
    //웬만하면 Entity의 PK는 LONG 타입의 auto_increment를 추천.
    //
    @Id
    //PK생성 규칙을 나타냄.
    //auto_increment
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //테이블의 컬럼을 나타낸다. 굳이 쓰지 않아도 해당 클래스의 필드는 모두 컬럼이 된다.
    //그럼에도 사용하는 이유 : 기본값 이외에 추가로 변경이 필요한 옵션이 있을 경우 사용한다.
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    //해당 클래스의 빌더 패턴 클래스 생성.
    //생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함된다.
    //생성자의 경우 인스턴스 생성 시 채워야할 필드가 무엇인지 명확히 지정 불가.
    //ex) Example.builder().a(a).b(b).build();
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
