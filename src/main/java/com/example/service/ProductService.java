package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    void createProduct(Product product);
    void updateProduct(String id, Product product);
    void deleteProduct(String id);
    Product getProduct(String id);
    Collection<Product> getProducts();
}