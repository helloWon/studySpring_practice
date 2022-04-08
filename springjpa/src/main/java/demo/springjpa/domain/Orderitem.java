package demo.springjpa.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import demo.springjpa.domain.item.Item;

public class Orderitem {
    @Id @GeneratedValue
    private Long id;

    private Item item;
    private Order order;
    private int orderPrice;
    private int count;
}
