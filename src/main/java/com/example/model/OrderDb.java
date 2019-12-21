package com.example.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "_order")
public class OrderDb {
    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="order_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    @Column(name = "ord_id")
    private Integer id;
    @Column(name = "user_id")
    private Integer user_id;
    @Column(name = "total_sum")
    private double totalSum;
    @Column(name = "ord_date")
    private Date ordDate;


    public OrderDb() {
    }

    public OrderDb(Integer user_id, double totalSum, Date ordDate) {
        this.user_id = user_id;
        this.totalSum = totalSum;
        this.ordDate = ordDate;
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
