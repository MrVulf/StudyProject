package com.example.service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.*;
import com.example.repository.OrderRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ShopCartService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

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

    public void makeOrder(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            Order order = new Order(
                    userId,
                    cart.calculateTotalPrice(),
                    new Date(),
                    cart.getProductList()
            );

            orderRepository.save(order);
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + userId);
        }
    }
}
