package com.h0lmes.fakeshop.web;

import com.h0lmes.fakeshop.model.ShoppingCart;
import com.h0lmes.fakeshop.service.ShoppingCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart/")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("{cartName}")
//    @Transactional()
    public ResponseEntity<ShoppingCart> getCartById(@PathVariable String cartName) {
        return ResponseEntity.ok(shoppingCartService.getShoppingCartByName(cartName));
    }

    @PutMapping("{cartName}")
//    @Transactional()
    public ResponseEntity<ShoppingCart> putDefaultProductToCart(@PathVariable String cartName) {
        return ResponseEntity.ok(shoppingCartService.putDefaultProductToCart(cartName));
    }

    @GetMapping("test/{cartName}")
//    @Transactional()
    public ResponseEntity<ShoppingCart> test(@PathVariable String cartName) {
        return ResponseEntity.ok(shoppingCartService.test(cartName));
    }

}
