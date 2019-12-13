package com.example.model;

import java.util.Map;


public class Order {
    private Integer id;
    private ShopCart cart;
    private double totalSum;

    public Order(Integer id, ShopCart cart) {
        this.id = id;
        this.cart = cart;
        totalSum = calculateTotalSum();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public ShopCart getCart() {
        return cart;
    }
    public void setCart(ShopCart cart) {
        this.cart = cart;
    }
    public double getTotalSum() {
        return totalSum;
    }
    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }
    /*
        Business Logic
    */
    private double calculateTotalSum(){
        Product product;
        Double total = 0.0;
        for(Map.Entry<Product,Integer> entry : cart.getProducts().entrySet()){
            total += entry.getKey().getPrice()*entry.getValue();
        }
        return total;
    }
}
