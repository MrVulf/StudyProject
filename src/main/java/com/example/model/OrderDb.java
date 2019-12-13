package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class OrderDb {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer user_id;
    @Column(name = "total_sum")
    private double totalSum;


    public OrderDb() {
    }

    public OrderDb(Order order) {
        this.id = order.getId();
        this.user_id = order.getCart().getUser();
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
    public Integer getUser_id() {
        return user_id;
    }
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
