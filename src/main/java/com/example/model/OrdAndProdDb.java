package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "order_prod")
public class OrdAndProdDb {
    @Id
    @Column(name = "ord_id")
    private Integer idOrd;

    @Column(name = "prod_id")
    private Integer idProd;

    @Column(name = "prod_number")
    private Integer numberProd;

    public OrdAndProdDb() {
    }
    public OrdAndProdDb(Integer idOrd, Integer idProd, Integer numberProd) {
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
    public Integer getNumberProd() {
        return numberProd;
    }
    public void setNumberProd(Integer numberProd) {
        this.numberProd = numberProd;
    }
}
