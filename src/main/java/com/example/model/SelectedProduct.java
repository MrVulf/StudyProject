package com.example.model;

import javax.persistence.*;
import java.util.Objects;

public class SelectedProduct {

    private Product product;

    private Integer amount;

    public SelectedProduct() {
    }

    public SelectedProduct(Product product, Integer amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
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
