package com.example.impl;

import com.example.model.OrdAndProdDb;
import com.example.model.Order;
import com.example.model.Product;
import com.example.repository.OrdAndProdDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrdAndProdDbServiceImpl {

    @Autowired
    private OrdAndProdDbRepository repository;

    public void putInDb(Order order) {
        Integer ord_id = order.getId(), prod_id, prodNumber;
        OrdAndProdDb fixation;
        for(Map.Entry entry : order.getCart().getProducts().entrySet()){
            prod_id = (Integer)entry.getKey();
            prodNumber = (Integer)entry.getValue();
            fixation = new OrdAndProdDb(ord_id,prod_id,prodNumber);
            repository.save(fixation);
        }
    }

    public void removeFromDb(OrdAndProdDb order) {
        repository.delete(order);
    }
}
