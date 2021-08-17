package com.h0lmes.fakeshop.web;

import com.h0lmes.fakeshop.model.Product;
import com.h0lmes.fakeshop.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Integer id) {
        return productService.findProductById(id);
    }

    @PostMapping("/product")
    public Product putProduct(@PathVariable Integer id, @RequestBody Product product) {
        return productService.putProduct(id, product);
    }

    @GetMapping("/healthcheck")
    public ResponseEntity<HttpStatus> healthcheck() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/health")
    public ResponseEntity<HttpStatus> health() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/stringv2")
    public String string() {
        return "Stringv2";
    }
    @GetMapping("/stringbody")
    public ResponseEntity<String> stringBody() {
        return new ResponseEntity<>("String", HttpStatus.OK);
    }
}
