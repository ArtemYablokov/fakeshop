package com.h0lmes.fakeshop.service;

import com.h0lmes.fakeshop.model.Product;
import com.h0lmes.fakeshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@XRayEnabled
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product findProductById(Long id) {
        Optional<Product> optionalProductById = repository.findById(id);
        return optionalProductById.orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public Product putProduct(Product product) {
        Long id = product.getId();
        return repository.save(product);
    }
}