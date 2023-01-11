package jpabook.jpashop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders") // 테이블 명 안적어주면 관례로 order 로 된다
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    // 생성 메서드 //
    // 여러 연관관계가 얽힌 복잡한 생성은 별도의 생성 메서드가 있으면 좋다.
    // 이렇게하면 order 가 쫙 세팅을 해서 이런스타일로 하면 앞으로 생성하는 지점 변경할거면 여기만 변경하면 됨
    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) { // ...문법으로 여러개 넘길 수 있음
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }

    /**
     * 주문 취소
     */
    public void cancel() {
        if (delivery.getStatus() == DeliveryStatus.COMP) {
            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능 합니다.");
        }

        this.setStatus(OrderStatus.CANCEL);
        for (OrderItem orderItem : orderItems) {
            orderItem.cancel(); // 원상복구
        }
    }


    // 조회 로직 //
    /**
     * 전체 주문 가격 조회
     */
    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getTotalPrice();
        }
        return totalPrice;
    }
}
