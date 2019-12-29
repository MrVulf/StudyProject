package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <com.example.model.Order,Integer> {
}
