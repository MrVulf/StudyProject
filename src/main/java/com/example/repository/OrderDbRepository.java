package com.example.repository;

import com.example.model.OrderDb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDbRepository extends JpaRepository <OrderDb,Integer> {
}
