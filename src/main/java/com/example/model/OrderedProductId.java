package com.example.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderedProductId implements Serializable {

    private Integer orderId;
    private Integer productId;

    public OrderedProductId(){
    }


    public OrderedProductId(Integer orderId, Integer productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public Integer getCustomerOrder() {
        return orderId;
    }

    public void setCustomerOrder(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProduct() {
        return productId;
    }

    public void setProduct(Integer productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedProductId that = (OrderedProductId) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId);
    }
}
