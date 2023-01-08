package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders") // 테이블 명 안적어주면 관례로 order 로 된다
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // order 와 member 는 다대일 관계, 멤버에서는 원 투 매니, 서로 반대
    @JoinColumn(name = "member_id") // 맵핑
     // 양방향에서는 연관관계의 주인을 FK 와 가까운 곳으로 정한다. 즉 여기서는 Order 가 연관관계의 주인
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL) // orderitem 의 order 에 의해 맵핑이 된다
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // 일대 일에서는 FK 를 어디다 두든 상관 없지만 FK 에 가까운 곳에 둔다, ORDER 에서 조회를 많이 하기 때문에 ORDER 에 둔다. (연관관계의 주인을 ORDER 로 둔다.)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // enum, 주문 상태 [ORDER, CANCEL]


    // == 연관관계 편의 메서드 == //
    // order 가 생성되면 멤버에도 order 추가해야됨 (양방향)
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }
}
