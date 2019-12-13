package com.example.model;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Table(name = "order_prod")
public class OrdAndProdDb {

    @Column(name = "ord_id")
    private Integer idOrd;

    @Column(name = "prod_id")
    private Integer idProd;

    @Column(name = "prod_number")
    private Double numberProd;

    public OrdAndProdDb() {
    }
    public OrdAndProdDb(Integer idOrd, Integer idProd, Double numberProd) {
        this.idOrd = idOrd;
        this.idProd = idProd;
        this.numberProd = numberProd;
    }
    public Integer getIdOrd() {
        return idOrd;
    }
    public void setIdOrd(Integer idOrd) {
        this.idOrd = idOrd;
    }
    public Integer getIdProd() {
        return idProd;
    }
    public void setIdProd(Integer idProd) {
        this.idProd = idProd;
    }
    public Double getNumberProd() {
        return numberProd;
    }
    public void setNumberProd(Double numberProd) {
        this.numberProd = numberProd;
    }
}
