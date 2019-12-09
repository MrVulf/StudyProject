package com.example.service;

import com.example.model.Product;
import com.example.model.ShopCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ShopCartService{
    void createShopCart(ShopCart cart);
    void updateShopCart(String id, ShopCart cart);
    void deleteShopCart(String id);
    void setProduct(Product product);
    Collection<Product> getProducts();
}
