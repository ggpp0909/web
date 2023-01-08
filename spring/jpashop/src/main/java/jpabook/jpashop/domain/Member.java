package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id") // 명세에서 pk 가 member_id 이므로 이름 부
    private Long id;

    private String name;

    @Embedded // Embedded 나 Address 클래스 내부에 Embeddable 둘 중 하나만 있어도 되긴 ㅐ
    private Address address;

    // 멤버와 order 는 1대 다 관계
    @OneToMany(mappedBy = "member") // 나는 연관관계의 주인이 아니야, order 테이블에 있는 member 필드에 의해 맵핑 될거야 (읽기 전용 거울일 뿐)
    private List<Order> orders = new ArrayList<>();


}
