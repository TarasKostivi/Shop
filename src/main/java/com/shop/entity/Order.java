package com.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int total;
    private boolean paid;

    @ManyToOne(fetch=FetchType.EAGER)
    private User user;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="order_product", joinColumns=@JoinColumn(name="order_id"),
            inverseJoinColumns=@JoinColumn(name="product_id"))

    private List<Product> products;

}
