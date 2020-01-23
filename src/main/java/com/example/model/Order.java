package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import lombok.*;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="order_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    @Column(name = "order_id")
    private Integer id;

    @Column(name = "user_id")
    @NotNull
    private Integer userId;

    @Column(name = "total_sum")
    @NotNull
    private double totalCost;

    @Column(name = "ord_date")
    @NotNull
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

}
