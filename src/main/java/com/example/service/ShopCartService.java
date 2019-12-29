package com.example.service;

import com.example.model.Order;
import com.example.model.Product;
import com.example.model.SelectedProduct;
import com.example.model.ShopCart;
import com.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShopCartService {

    @Autowired
    private OrderRepository orderRepository;

    private ShopCart cart = new ShopCart();

    public List<SelectedProduct> getProductsInCart() {
        return cart.getProductList();
    }

    public Double getTotal() {
        return cart.calculateTotalPrice();
    }

    public Product addProduct(Product product) {
        cart.addProduct(product);
        return product;
    }

    public void removeProduct(Product product) {
        cart.removeProduct(product);
    }

    public void makeOrder(Integer userId){
        Order order = new Order(
                userId,
                cart.calculateTotalPrice(),
                new Date(),
                cart.getProductList()
        );

        orderRepository.save(order);
    }
}
