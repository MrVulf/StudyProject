package com.example.repository;

import com.example.model.Product;
//import javafx.scene.control.Pagination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findById(Long id);
    List<Product> findAll();
//    List<Product> findAll(Pagination pagination);

}
