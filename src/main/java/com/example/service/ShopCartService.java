package com.example.service;

import com.example.model.Product;
import com.example.model.ShopCart;

import java.util.Collection;
import java.util.List;

public interface ShopCartService{

    ShopCart createShopCart(ShopCart cart);
    void deleteShopCart(String cartId);
    ShopCart setProduct(String cartId, Product product);
    ShopCart remProduct(String cartId, Product product);
    List<Product> getProducts(String cartId);

}
