package com.example.service;

import com.example.exception.NotEnoughProductsInStockException;
import com.example.exception.NotProductsInShopCartException;
import com.example.model.Product;
import com.example.model.SelectedProduct;

import java.util.List;

public interface ShopCartService  {
    Product addProduct(Product product);
    void removeProduct(Product product);
    void removeProduct(Product product, int amount);
    List<SelectedProduct> getProductsInCart();
    double getTotal();
}