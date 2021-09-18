package com.h0lmes.fakeshop.model;

import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY/*, generator = "sequence_generator"*/)
//    @SequenceGenerator(name = "sequence_generator")
    private Long id;
    @Column(unique = true)
    private String name;
    private Integer total;
    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Product> products;

    public int calculateSum() {
        if (CollectionUtils.isEmpty(this.products)) {
            return 0;
        }
        this.total = this.products.stream().mapToInt(Product::calculateSum).sum();
        return total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
