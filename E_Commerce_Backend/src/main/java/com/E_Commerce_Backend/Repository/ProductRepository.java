package com.E_Commerce_Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.E_Commerce_Backend.Models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Add custom query methods if needed
}
