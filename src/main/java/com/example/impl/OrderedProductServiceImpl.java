package com.example.impl;

import com.example.model.Order;
import com.example.model.OrderedProduct;
import com.example.repository.OrderedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderedProductServiceImpl {

    @Autowired
    OrderedProductRepository repository;

    public void addDetailInDB(Order order){
        for(OrderedProduct product : order.getProductList()){
            repository.save(product);
        }
    }

}
