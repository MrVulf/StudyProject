package com.example.controller;

import com.example.service.ProductService;
import com.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@Controller
@RequestMapping("/test/product")
public class TestProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/get-all")
    @ResponseBody
    public Collection<Product> getAllProducts() {
        return productService.getAllProduct();
    }

    @GetMapping(value = "/get/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable String id){
        return productService.getProductById(Integer.getInteger(id));
    }


    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> newProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(this.productService.createProduct(product));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity < Product > updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        Product repProd = productService.updateProduct(id, product);
        if(product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(repProd);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        this.productService.deleteProduct(id);
    }
}
