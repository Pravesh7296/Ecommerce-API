package com.E_Commerce_Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.E_Commerce_Backend.Models.Cart;
import com.E_Commerce_Backend.Service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("cartById/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable("id") int id) {
        Cart cart = cartService.getCartById(id);
        return ResponseEntity.ok(cart);
    }

   
  
}
