package com.E_Commerce_Backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.E_Commerce_Backend.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findAll();
    // Add custom query methods if needed
}

