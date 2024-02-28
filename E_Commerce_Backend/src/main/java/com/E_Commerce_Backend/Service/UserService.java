package com.E_Commerce_Backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_Commerce_Backend.Exception.ResourceNotFoundException;
import com.E_Commerce_Backend.Models.User;
import com.E_Commerce_Backend.Repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User getUserById(int id) {
        return userRepository.findById(id)
                              .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }
    
    public User createUser(User user) {
        return userRepository.save(user);
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
        userRepository.delete(user);
    }
}

