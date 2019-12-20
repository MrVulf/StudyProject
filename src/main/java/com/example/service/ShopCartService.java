package com.example.service;

import com.example.exception.NotEnoughProductsInStockException;
import com.example.model.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface ShopCartService  {
    void addProduct(Product product);
    void removeProduct(Product product);
    Map<Product, Integer> getProductsInCart();
    void checkout(Integer user_id) throws NotEnoughProductsInStockException;
    double getTotal();
}