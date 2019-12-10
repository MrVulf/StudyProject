package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    List < Product > getAllProduct();
    Product getProductById(Integer productId);
    void deleteProduct(Integer id);
}