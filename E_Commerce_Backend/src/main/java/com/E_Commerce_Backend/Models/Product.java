package com.E_Commerce_Backend.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
     @NotEmpty
	 private String title;
	 private double price;
	 private String description;
	 private boolean availability;
	 private int stock;
	 @ManyToOne
	 private Category category;
	   

}
