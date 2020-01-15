package com.example.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="order_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    @Column(name = "order_id")
        @Getter @Setter private Integer id;

    @Column(name = "user_id")
        @Getter @Setter private Integer userId;

    @Column(name = "total_sum")
        @Getter @Setter private double totalCost;

    @Column(name = "ord_date")
        @Getter @Setter private Date ordDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
        @Getter @Setter private List<SelectedProduct> productList;


    public Order() {
    }

    public Order(Integer userId, double totalCost, Date ordDate, List<SelectedProduct> productList) {
        this.userId = userId;
        this.totalCost = totalCost;
        this.ordDate = ordDate;
        this.productList = productList;
    }

}
