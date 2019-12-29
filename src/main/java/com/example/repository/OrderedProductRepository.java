package com.example.repository;

import com.example.model.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedProductRepository extends JpaRepository <OrderedProduct,Integer>{
}
