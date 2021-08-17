package com.h0lmes.fakeshop.service;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.h0lmes.fakeshop.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@XRayEnabled
public class ProductServiceImpl implements ProductService {

    private final Map<Integer, Product> repository = new HashMap<>();

    @Override
    public Product findProductById(Integer id) {
        return repository.get(id);
    }

    @Override
    public Product putProduct(Product product) {
        Integer id = product.getId();
        repository.put(id, product);
        return findProductById(id);
    }
}