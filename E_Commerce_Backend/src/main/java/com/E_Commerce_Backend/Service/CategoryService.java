package com.E_Commerce_Backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_Commerce_Backend.Exception.ResourceNotFoundException;
import com.E_Commerce_Backend.Models.Category;
import com.E_Commerce_Backend.Repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id)
                                  .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
    }
    
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    
    public Category updateCategory(int id, Category categoryDetails) {
        Category category = getCategoryById(id);
        category.setName(categoryDetails.getName());
        return categoryRepository.save(category);
    }
    
    public void deleteCategory(int id) {
        Category category = getCategoryById(id);
        categoryRepository.delete(category);
    }
}
