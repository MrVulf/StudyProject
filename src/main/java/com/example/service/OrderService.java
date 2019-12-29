package com.example.service;

import com.example.model.Order;

public interface OrderService {
    Order addOrderInDB(Order order);
    Order updateOrder(int id, Order upOrder);
    Order getOrderById(Integer orderId);
    void deleteOrder(Integer id);
}
