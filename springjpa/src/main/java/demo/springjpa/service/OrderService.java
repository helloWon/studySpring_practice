package demo.springjpa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.springjpa.domain.Delivery;
import demo.springjpa.domain.Member;
import demo.springjpa.domain.Order;
import demo.springjpa.domain.OrderItem;
import demo.springjpa.domain.item.Item;
import demo.springjpa.repository.ItemRepository;
import demo.springjpa.repository.MemberRepository;
import demo.springjpa.repository.OrderRepository;
import demo.springjpa.repository.OrderSearch;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        OrderItem orderitem = OrderItem.createOrderItem(item, item.getPrice(), count);
        Order order = Order.createOrder(member, delivery, orderitem);
        orderRepository.save(order);

        return order.getId();
    }

    @Transactional
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findOne(orderId);
        order.cancel();
    }

    @Transactional
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAllByStr(orderSearch);
    }
}
