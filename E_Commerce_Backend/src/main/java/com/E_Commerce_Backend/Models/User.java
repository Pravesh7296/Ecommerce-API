package com.E_Commerce_Backend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
   	private int id;
     
     private String  name;
     
     @Email(message = "Please enter valid email address")
     private String email;
     @Column(nullable = false,unique = true)
     private String username;
     @NotEmpty(message = "password should not be empty")
     @JsonProperty(access = Access.WRITE_ONLY)
     @Size(min = 6,message = "password should have length of 6")
     private String password;
     @JsonIgnore
     @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
     private Cart cart;
     
     private String role;
	

}
