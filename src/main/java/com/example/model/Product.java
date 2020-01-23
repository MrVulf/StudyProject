package com.example.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "products")
public class Product {

    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="prod_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    @NotNull
    private String name;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "quantity", nullable = false)
    @NotNull
    private Integer quantity;

    @Column(name = "price", nullable = false)
    @NotNull
    private Double price;

    public Product() {
    }
}
