package demo.springjpa.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import demo.springjpa.domain.item.Item;

@Entity
public class Category {
    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;
    @ManyToMany
    private List<Item> items;
    private Category parent;
    private List<Category> child;
}
