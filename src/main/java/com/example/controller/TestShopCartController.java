package com.example.controller;

import com.example.model.Order;
import com.example.model.Product;
import com.example.model.SelectedProduct;
import com.example.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/test/shop-cart")
public class TestShopCartController {
    @Autowired
    private ShopCartService cartService;

    @GetMapping("/current-prod")
    @ResponseStatus(code = HttpStatus.FOUND)
    @ResponseBody
    public List<SelectedProduct> getAllProduct() {
        return cartService.getProductsInCart();
    }

    @GetMapping("/get-total")
    @ResponseBody
    public Double getTotal() {
        return cartService.getTotal();
    }

    @PostMapping("/add-prod")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<Product> putProduct(@RequestBody Product product) {
        return ResponseEntity.ok(cartService.addProduct(product));
    }

    @PostMapping("/checkout/{id}")
    @ResponseBody
    public void finishOrder(@PathVariable Integer id) {
        cartService.makeOrder(id);
    }

    @PutMapping("/remove-prod")
    @ResponseBody
    public void removeProd(@RequestBody Product product) {
        cartService.removeProduct(product);
    }
}
