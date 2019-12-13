package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "shop_carts")
public class ShopCart {
    @Id
    @Column(name = "cart_id")
    private Integer id;

    @Column(name = "products")
    private List<Product> products;

    public ShopCart() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public void setProduct(Product theProduct){
        products.add(theProduct);
    }
    public void remProduct(Product theProduct) {products.remove(theProduct);}
}
