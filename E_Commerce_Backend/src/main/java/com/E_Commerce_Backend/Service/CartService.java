package com.E_Commerce_Backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_Commerce_Backend.Exception.ResourceNotFoundException;
import com.E_Commerce_Backend.Models.Cart;
import com.E_Commerce_Backend.Repository.CartRepository;

@Service
public class CartService {
    
    @Autowired
    private CartRepository cartRepository;
    
    public Cart getCartById(int id) {
        return cartRepository.findById(id)
                             .orElseThrow(() -> new ResourceNotFoundException("Cart not found with id: " + id));
    }
    
//    public Cart createCart(Cart cart) {
//        return cartRepository.save(cart);
//    }
//    
//    public Cart deleteCart(int id) {
//        Cart cart = getCartById(id);
//	 cartRepository.delete(cart);
//	 return cart;
//     
   // }
}

