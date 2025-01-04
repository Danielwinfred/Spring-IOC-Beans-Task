package com.example.productcatalog.controller;

import com.example.productcatalog.model.Product;  // Import the Product class
import com.example.productcatalog.repository.ProductRepository;  // Import the ProductRepository
import org.springframework.beans.factory.annotation.Autowired;  // Import Autowired annotation
import org.springframework.web.bind.annotation.GetMapping;  // Import GET annotation for HTTP requests
import org.springframework.web.bind.annotation.PostMapping;  // Import POST annotation for HTTP requests
import org.springframework.web.bind.annotation.RequestBody;  // Import RequestBody to bind request data

import java.util.List;  // Import List to return multiple products

@org.springframework.web.bind.annotation.RestController  // This makes the class a REST API controller
public class ProductController {

    @Autowired  // Spring will automatically inject the ProductRepository here
    private ProductRepository productRepository;

    // Handle GET request to retrieve all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();  // Returns all products from the database
    }

    // Handle POST request to add a new product
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);  // Save the product to the database
    }
}
