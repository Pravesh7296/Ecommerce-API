package com.E_Commerce_Backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_Commerce_Backend.Exception.ResourceNotFoundException;
import com.E_Commerce_Backend.Models.Cart;
import com.E_Commerce_Backend.Models.User;
import com.E_Commerce_Backend.Repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CartService cartService;
    
   
    
    public User getUserById(int id) {
        return userRepository.findById(id)
                              .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }
    
    public User createUser(User user) {
    
    	if(user.getName()!=null && user.getPassword()!=null) {
                 
    		User user1 = userRepository.save(user);
        	cartService.createCart(user1);
        	
    		
        	return user1;
    	}else {
    		throw new ResourceNotFoundException("User should not be Empty !");
    	}
       
    }
    
    public User updateUser(int id, User userDetails) {
        User user = getUserById(id);
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        // Update other fields as needed
        return userRepository.save(user);
    }
    
    public void deleteUser(int id) {
    	
    	
        User user = getUserById(id);
        if(user!=null) {
        	 cartService.deleteCart(id);
        	 userRepository.delete(user);
        }else {
        	throw new ResourceNotFoundException("User not Found !");
        }
       
    }
    
    //viewCartItems
    //placeYourOrder return price message
    //cancleOrder 
    //AddToCart input product 
       
       
    
}

