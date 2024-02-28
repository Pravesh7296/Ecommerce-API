package com.E_Commerce_Backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_Commerce_Backend.Exception.ResourceNotFoundException;
import com.E_Commerce_Backend.Models.Cart;
import com.E_Commerce_Backend.Models.User;
import com.E_Commerce_Backend.Repository.CartRepository;
import com.E_Commerce_Backend.Repository.UserRepository;

@Service
public class CartService {
    
    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    public Cart getCartById(int id) {
        return cartRepository.findById(id)
                             .orElseThrow(() -> new ResourceNotFoundException("Cart not found with id: " + id));
    }
    
    public Cart createCart(User user ) {
    	Cart cart = new Cart();
    	Cart cart1 = cartRepository.save(cart);
    	user.setCart(cart1);
    	cart1.setUser(user);
return cartRepository.save(cart);
        
    }
    
    public void deleteCart(int id) {
        Cart cart = getCartById(id);
        cartRepository.delete(cart);
    }
}

