package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "ordered_product")
public class OrderedProduct {
    @EmbeddedId
    private OrderedProductId pk = new OrderedProductId();

    @MapsId("orderId")
    @JoinColumn(name = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Order order;

    @MapsId("productId")
    @JoinColumn(name = "product_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderedProduct that = (OrderedProduct) o;
        if (getPk() != null ? !getPk().equals(that.getPk()) : that.getPk() != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }

    public OrderedProductId getPk() {
        return pk;
    }

    public void setPk(OrderedProductId pk) {
        this.pk = pk;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
        getPk().setCustomerOrder(order.getId());
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        getPk().setProduct(product.getId());
    }

}
