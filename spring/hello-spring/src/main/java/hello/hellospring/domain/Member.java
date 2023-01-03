package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {

    // @Id는 PK 매핑, @GeneratedValue 는 DB 에서 알아서 생성해 준거라는 뜻 이런 것을 아이덴티티 전략이라고 함
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 고객 아이디가 아닌 데이터 구분용 아이디
    // @Column(name = "username") DB의 컬럼명이 다르면 이렇게 명시
    private String name; // 고객 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
