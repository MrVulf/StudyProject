package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/test")
public class TestProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public List<Product> getAllCountries() {
        return productService.getAll();
    }

    @GetMapping("/products&{productId}")
    public Optional<Product> getProductById(@RequestParam Long id){
        return productService.getProductById(id);
    }
}
