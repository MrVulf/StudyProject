package com.example.impl;

import com.example.exception.NotEnoughProductsInStockException;
import com.example.model.OrdAndProdDb;
import com.example.model.OrderDb;
import com.example.model.Product;
import com.example.repository.OrdAndProdDbRepository;
import com.example.repository.OrderDbRepository;
import com.example.repository.ProductRepository;
import com.example.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrdAndProdDbRepository parityRepository;
    @Autowired
    private OrderDbRepository orderRepository;

    private Map<Product, Integer> products = new HashMap<>();


    @Override
    public void addProduct(Product product) {
        if (products.containsKey(product)) {
            products.replace(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
    }

    @Override
    public void removeProduct(Product product) {
        if (products.containsKey(product)) {
            if (products.get(product) > 1)
                products.replace(product, products.get(product) - 1);
            else if (products.get(product) == 1) {
                products.remove(product);
            }
        }
    }

    @Override
    public Map<Product, Integer> getProductsInCart() {
        return Collections.unmodifiableMap(products);
    }

    @Override
    public void checkout(Integer user_id) throws NotEnoughProductsInStockException {
        double total = 0.0;
        Product product;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            // Refresh quantity for every product before checking
            product = productRepository.findById(entry.getKey().getId()).get();
            if (product.getQuantity() < entry.getValue())
                throw new NotEnoughProductsInStockException(product);
            entry.getKey().setQuantity(product.getQuantity() - entry.getValue());
            total += entry.getValue()*entry.getKey().getPrice();
        }
        /*
            If all is ok -> write down info in DB
        */
        OrderDb newOrder = new OrderDb(user_id, total);
        orderRepository.save(newOrder);
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            OrdAndProdDb note = new OrdAndProdDb(
                    newOrder.getId(),
                    entry.getKey().getId(),
                    entry.getValue()
            );
            parityRepository.save(note);
            // Change notes about product quantity in DB
            product = productRepository.findById(entry.getKey().getId()).get();
            product.setQuantity(product.getQuantity() - entry.getValue());
            productRepository.save(product);
        }
        products.clear();
    }

    @Override
    public double getTotal() {
        double total = 0;
        Product product;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            product = productRepository.findById(entry.getKey().getId()).get();
            total += entry.getValue()*entry.getKey().getPrice();
        }
        return total;
    }
}