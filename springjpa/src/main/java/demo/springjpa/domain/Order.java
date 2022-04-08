package demo.springjpa.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Order {
    @Id @GeneratedValue
    private Long id;
    private Member member;
    private List<Orderitem> orderitems;
    private Delivery delivery;
    private Date orderDate;
    private OrderStatus status;
}
