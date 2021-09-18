package com.h0lmes.fakeshop.repository;

import com.h0lmes.fakeshop.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
