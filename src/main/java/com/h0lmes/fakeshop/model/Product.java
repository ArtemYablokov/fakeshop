package com.h0lmes.fakeshop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY/*, generator = "sequence_generator"*/)
//    @SequenceGenerator(name = "sequence_generator")
    private Long id;
    private String name;
    private Integer price;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart cart;

    public Product() {}

    public Integer calculateSum(){
        return this.price * this.quantity;
    }

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public Product setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
