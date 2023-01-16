package jpabook.jpashop.service;

import jpabook.jpashop.domain.Delivery;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    /**
     * 주문
     */
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {

        // 엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        // 배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        // 주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        // 주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        // 주문 저장
        orderRepository.save(order); // 이거 하나만 save 해도 다른것들 cascade 옵션 걸려있는것들(orderItem, delivery)도 자동으로 save 된다.
        // order 가 delivery 와 orderItem 을 관리, 이 둘은 다른데선 안씀, 이처럼 order 가 private owner 일 경우 cascade 로 도움을 받을 수 있음
        // 하지만 delivery 가 다른 곳에서도 쓰이고 그런거면 cascade 막 쓰면 안됨, 왜냐하면 order 지울때 저것도 다 지워지고 그럴경우도 있기 때문
        return order.getId();
    }

    // 취소
    @Transactional
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findOne(orderId);
        order.cancel(); // 원래는 SQL 로 업데이트 쿼리 다 날려줘야함
        // JPA 의 강점이 여기서 나옴, 엔티티안에 있는 데이터가 바뀌면 JPA 가 변경된 내역들 찾아서(더티체킹) 업데이트 쿼리를 날려줌
    }

    // 검색
    // 이런 단순 조회같은경우는 컨트롤러에서 바로 사용해도 괜찮다
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAllByCriteria(orderSearch);
    }
}
