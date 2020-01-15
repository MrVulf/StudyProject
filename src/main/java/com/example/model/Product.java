package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="prod_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    @Column(name = "product_id")
        @Getter @Setter private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    //@Length(min = 3, message = "*Name must have at least 5 characters")
        @Getter @Setter private String name;

    @Column(name = "description")
        @Getter @Setter private String description;

    @Column(name = "quantity", nullable = false)
    //@Min(value = 0, message = "*Quantity has to be non negative number")
        @Getter @Setter private Integer quantity;

    @Column(name = "price", nullable = false)
    //@DecimalMin(value = "0.00", message = "*Price has to be non negative number")
        @Getter @Setter private Double price;

    public Product() {
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
