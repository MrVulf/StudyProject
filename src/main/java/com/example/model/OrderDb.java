package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "Order")
public class OrderDb {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "totalSum")
    private double totalSum;


    public OrderDb() {
    }

    public OrderDb(Order order) {
        this.id = order.getId();
        this.totalSum = order.getTotalSum();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public double getTotalSum() {
        return totalSum;
    }
    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }
}
