package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @One(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // 이넘 타입은 이걸 넣어줘야 함, ORDINAL 은 0 1 2 이런식으로 매칭 되는데 중간에 다른 값 추가되면 밀려서 망함, 꼭 STRING으로 쓰기
    private DeliveryStatus status; // READY, COMP(배송)
}
