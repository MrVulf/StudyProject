package com.example.impl;

import com.example.exception.NotEnoughProductsInStockException;
import com.example.exception.NotProductsInShopCartException;
import com.example.model.Order;
import com.example.model.Product;
import com.example.model.SelectedProduct;
import com.example.model.ShopCart;
import com.example.repository.OrderRepository;
import com.example.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCartServiceImpl implements ShopCartService {

    private ShopCart shopCart = new ShopCart();

    @Override
    public Product addProduct(Product product) {
        shopCart.addProduct(product);
        return product;
    }

    @Override
    public void removeProduct(Product product) {
        shopCart.removeProduct(product);
    }
    @Override
    public void removeProduct(Product product, int amount) {
        shopCart.removeProduct(product, amount);
    }

    @Override
    public List<SelectedProduct> getProductsInCart() {
        return shopCart.getProductList();
    }

    @Override
    public double getTotal() {
        return shopCart.calculateTotalPrice();
    }

    public ShopCart getShopCart() {
        return shopCart;
    }
}
