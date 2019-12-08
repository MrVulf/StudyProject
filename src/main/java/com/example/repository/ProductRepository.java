package com.example.repository;

import com.example.model.Product;
//import javafx.scene.control.Pagination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findById(@Param("id") Long id);
    List<Product> findAll();
//  List<Product> findAll(Pagination pagination);

    void removeById(@Param("id") Long id);
}
