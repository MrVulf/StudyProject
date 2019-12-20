package com.example.service;

import com.example.model.Product;
import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Integer id, Product product);
    List < Product > getAllProduct();
    Product getProductById(Integer productId);
    void deleteProduct(Integer id);
}