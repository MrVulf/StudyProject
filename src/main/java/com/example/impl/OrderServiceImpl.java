package com.example.impl;

import com.example.model.*;
import com.example.repository.OrderRepository;
import com.example.repository.OrderedProductRepository;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    public Order makeOrder(Integer userId, Date date, ShopCart cart){

        Order order = new Order(userId, cart.calculateTotalPrice(), date);


        List<SelectedProduct> productList = cart.getProductList();
        List<OrderedProduct> orderedProductList = new ArrayList<>();
        // Transform list
        for(SelectedProduct currProd : productList){
            OrderedProduct orderedProduct = new OrderedProduct();
            orderedProduct.setOrder(order);
            orderedProduct.setProduct(currProd.getProduct());
            orderedProduct.setQuantity(currProd.getAmount());
            orderedProduct.setPk(new OrderedProductId(order.getId(),currProd.getProduct().getId()));

            orderedProductList.add(orderedProduct);
        }
        order.setProductList(orderedProductList);

        return order;
    }

    @Override
    public Order addOrderInDB(Order order) {
        repository.save(order);

        return order;
    }

    @Override
    public Order updateOrder(int id, Order upOrder) {
        return null;
    }

    @Override
    public Order getOrderById(Integer orderId) {
        return null;
    }

    @Override
    public void deleteOrder(Integer id) {

    }
}
