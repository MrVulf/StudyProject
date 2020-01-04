package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "prod_amount")
public class SelectedProduct {

    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="prod_amount_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    @Column(name = "id")
        @Getter @Setter private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id")
        @Getter @Setter private Product product;

    @Column(name = "prod_amount")
        @Getter @Setter private Integer amount;

    public SelectedProduct() {
    }

    public SelectedProduct(Product product, Integer amount) {
        this.product = product;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelectedProduct product1 = (SelectedProduct) o;
        return Objects.equals(product, product1.product) &&
                Objects.equals(amount, product1.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, amount);
    }
}
