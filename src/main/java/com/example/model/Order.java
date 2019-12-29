package com.example.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="order_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "total_sum")
    private double totalCost;
    @Column(name = "ord_date")
    private Date ordDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<SelectedProduct> productList;


    public Order() {
    }

    public Order(Integer userId, double totalCost, Date ordDate, List<SelectedProduct> productList) {
        this.userId = userId;
        this.totalCost = totalCost;
        this.ordDate = ordDate;
        this.productList = productList;
    }

    public Date getOrdDate() {
        return ordDate;
    }
    public void setOrdDate(Date ordDate) {
        this.ordDate = ordDate;
    }
   public List<SelectedProduct> getProductList() {
        return productList;
    }
    public void setProductList(List<SelectedProduct> productList) {
        this.productList = productList;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer user_id) {
        this.userId = user_id;
    }
}
