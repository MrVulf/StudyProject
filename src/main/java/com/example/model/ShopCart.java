package com.example.model;

import java.util.ArrayList;
import java.util.List;


public class ShopCart {

    private List<SelectedProduct> productList = new ArrayList<>();

    public ShopCart() {
    }

    public List<SelectedProduct> getProductList() {
        return productList;
    }

    public List<ProductAndAmount> getOrderProductList(){
        List<ProductAndAmount> list = new ArrayList<>();

        for(SelectedProduct product : productList){
            list.add(new ProductAndAmount(product.getProduct().getId(), product.getAmount()));
        }

        return list;
    }

    public void setProductList(List<SelectedProduct> productList) {
        this.productList = productList;
    }

    public Double calculateTotalPrice(){
        Double price = 0.0;
        for(SelectedProduct product : productList){
            price += product.getAmount()*product.getProduct().getPrice();
        }
        return price;
    }

    public void addProduct(Product product){
        for(SelectedProduct product1 : productList){
            if(product.equals(product1.getProduct())){
                product1.setAmount(product1.getAmount()+1);
                return;
            }
        }
        // if the product hadn't add
        SelectedProduct newProduct = new SelectedProduct(product, 1);
        productList.add(newProduct);
    }

    public void removeProduct(Product product){
        for(SelectedProduct product1 : productList){
            if(product.equals(product1.getProduct())){
                productList.remove(product1);
                break;
            }
        }
    }

    public void removeProduct(Product product, int amount){
        for(SelectedProduct product1 : productList){
            if(product.equals(product1.getProduct())){

                if(product1.getAmount() - amount >= 0){
                    product1.setAmount(product1.getAmount()-amount);
                    break;
                }
                // if the amount is too much
                else{
                    removeProduct(product);
                }
            }
        }
    }
}
