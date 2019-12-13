package com.example.impl;

import com.example.model.OrdAndProdDb;
import com.example.repository.OrdAndProdDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdAndProdDbServiceImpl {

    @Autowired
    private OrdAndProdDbRepository repository;

    public void putInDb(OrdAndProdDb order) {
        repository.save(order);
    }

    public void removeFromDb(OrdAndProdDb order) {
        repository.delete(order);
    }
}
