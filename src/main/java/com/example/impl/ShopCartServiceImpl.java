package com.example.impl;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Product;
import com.example.model.ShopCart;
import com.example.repository.ShopCartRepository;
import com.example.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;

@Service
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired
    private ShopCartRepository repository;

    @Override
    public ShopCart createShopCart(ShopCart cart) {
        return repository.save(cart);
    }

    @Override
    public void deleteShopCart(String cartId) {

        Optional<ShopCart> cartDb = repository.findById(Integer.getInteger(cartId));

        if (cartDb.isPresent()) {
            this.repository.delete(cartDb.get());
        } else {

            throw new ResourceNotFoundException("Record not found with id : " + cartId);
        }
    }

    @Override
    public ShopCart setProduct(String cartId, Product product){
        Optional<ShopCart> cartDb = repository.findById(Integer.getInteger(cartId));
        if(cartDb.isPresent()){
            ShopCart cartUp = cartDb.get();
            cartUp.setProduct(product);
            return cartUp;
        } else{
            throw new ResourceNotFoundException("Record not found with id : " + cartId);
        }
    }

    @Override
    public ShopCart remProduct(String cartId, Product product) {
        Optional<ShopCart> cartDb = repository.findById(Integer.getInteger(cartId));
        if(cartDb.isPresent()){
            ShopCart cartUp = cartDb.get();
            cartUp.remProduct(product);
            return cartUp;
        } else{
            throw new ResourceNotFoundException("Record not found with id : " + cartId);
        }
    }

    @Override
    public Map<Product, Integer> getProducts(String cartId) {
        Optional<ShopCart> cartDb = repository.findById(Integer.getInteger(cartId));
        if(cartDb.isPresent()){
            ShopCart cartUp = cartDb.get();
            return cartUp.getProducts();
        } else{
            throw new ResourceNotFoundException("Record not found with id : " + cartId);
        }
    }
}
