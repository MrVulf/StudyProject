package com.example.impl;

import com.example.model.Order;
import com.example.model.OrderDb;
import com.example.repository.OrderDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDbServiceImpl{

    @Autowired
    private OrderDbRepository repository;

    public void putInDb(Order order) {
        OrderDb orderDb = new OrderDb(order);
        repository.save(orderDb);
    }

    public void removeFromDb(OrderDb order) {
        repository.delete(order);
    }
}
