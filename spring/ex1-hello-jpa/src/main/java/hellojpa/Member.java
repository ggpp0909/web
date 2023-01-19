package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // 이걸 꼭 넣어야 JPA를 사용하는 애구나, 관리해야겠구나 라고 인식함
//@Table(name = "USER") 이런식으로 테이블 명이 Member 와 다를경우 맵핑해야함
public class Member {

    @Id // 이걸 꼭 넣어야 PK로 인식
    private Long id;
//    @Column(name = "username") 이런식으로 컬럼명 다를경우 맵핑 하면됨
    private String name;

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
