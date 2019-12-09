package com.example.model;

import java.util.Collection;

public class ShopCart {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public ShopCart() {
    }

    private Collection<Product> products;
}
