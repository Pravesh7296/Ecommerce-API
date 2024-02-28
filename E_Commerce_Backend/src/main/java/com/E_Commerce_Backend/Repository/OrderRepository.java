package com.E_Commerce_Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.E_Commerce_Backend.Models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    // Add custom query methods if needed
}
