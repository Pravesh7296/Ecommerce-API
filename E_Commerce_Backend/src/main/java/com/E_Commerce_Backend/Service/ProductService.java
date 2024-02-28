package com.E_Commerce_Backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_Commerce_Backend.Exception.ResourceNotFoundException;
import com.E_Commerce_Backend.Models.Category;
import com.E_Commerce_Backend.Models.Product;
import com.E_Commerce_Backend.Repository.CategoryRepository;
import com.E_Commerce_Backend.Repository.ProductRepository;
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
     	 @Autowired
	    private CategoryRepository categoryRepository;
	public List<Product> getAllProducts() {
	    return productRepository.findAll();
	}

	public Product getProductById(int id) {
	    return productRepository.findById(id)
	                             .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
	}

	public Product createProduct(Product product) {
//	     Category category= product.getCategory();
//	    Category cat= categoryRepository.findByname(category.getName());
//	      if(cat!=null) {
//	    	  product.setCategory(cat);
//	    	  
//	      }
	    
		return productRepository.save(product);
	}

	public Product updateProduct(int id, Product productDetails) {
	    Product product = getProductById(id);
	    product.setTitle(productDetails.getTitle());
	    product.setPrice(productDetails.getPrice());
	    product.setDescription(productDetails.getDescription());
	    product.setAvailability(productDetails.isAvailability());
	    product.setCategory(productDetails.getCategory());
	    return productRepository.save(product);
	}

	public void deleteProduct(int id) {
	    Product product = getProductById(id);
	    productRepository.delete(product);
	}
}