package com.h0lmes.fakeshop.repository;

import com.h0lmes.fakeshop.model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {


    Optional<ShoppingCart> findByName(String name);
}
