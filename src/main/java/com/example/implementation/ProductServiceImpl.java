package com.example.implementation;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(String id, Product product) {
        productRepository.removeById(Long.getLong(id));
        product.setId(Integer.getInteger(id));
        productRepository.saveAndFlush(product);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.delete(productRepository.findById(Long.getLong(id)));
    }

    @Override
    public Product getProduct(String id) {
        return productRepository.findById(Long.getLong(id));
    }

    @Override
    public Collection<Product> getProducts() {
        return productRepository.findAll();
    }
}
