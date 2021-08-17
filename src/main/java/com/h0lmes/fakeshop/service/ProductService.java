package com.h0lmes.fakeshop.service;

import com.h0lmes.fakeshop.model.Product;

public interface ProductService {
    Product findProductById(Integer id);
    Product putProduct(Integer id, Product product);
}
