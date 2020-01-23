package com.example.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "prod_amount")
public class SelectedProduct {

    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="prod_amount_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull
    private Product product;

    @Column(name = "prod_amount")
    @NotNull
    private Integer amount;

    public SelectedProduct() {
    }

    public SelectedProduct(Product product, Integer amount) {
        this.product = product;
        this.amount = amount;
    }
}
