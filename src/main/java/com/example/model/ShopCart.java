package com.example.model;

import java.util.HashMap;
import java.util.Map;


public class ShopCart {

    private Integer id;
    private User user;
    private Map<Product,Integer> products;

    public ShopCart(Integer id, User user) {
        this.id = id;
        this.user = user;
        products = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Map<Product,Integer> getProducts() {
        return products;
    }
    public void setProduct(Product theProduct){
        if(products.containsKey(theProduct)){
            products.replace(theProduct, products.get(theProduct)+1);
        } else{
            products.put(theProduct,1);
        }
    }
    public void remProduct(Product theProduct) {
        if(products.containsKey(theProduct)){
            if(products.get(theProduct) != 1)
                products.replace(theProduct, products.get(theProduct)-1);
            else
                products.remove(theProduct);
        } else{
            throw new IllegalArgumentException();
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
