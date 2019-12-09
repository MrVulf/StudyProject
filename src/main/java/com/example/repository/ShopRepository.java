package com.example.repository;

import com.example.model.ShopCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<ShopCart, Integer> {

}