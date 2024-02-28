package com.E_Commerce_Backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_Commerce_Backend.Exception.ResourceNotFoundException;
import com.E_Commerce_Backend.Models.Order;
import com.E_Commerce_Backend.Repository.OrderRepository;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    public Order getOrderById(int id) {
        return orderRepository.findById(id)
                              .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
    }
    
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
    
    public void deleteOrder(int id) {
        Order order = getOrderById(id);
        orderRepository.delete(order);
    }
}

