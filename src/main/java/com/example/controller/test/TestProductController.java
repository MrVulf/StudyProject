package com.example.controller.test;

import com.example.impl.ProductServiceImpl;
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
    private ProductServiceImpl productService;

    @GetMapping(value = "/products")
    @ResponseBody
    public Collection<Product> getAllProducts() {
        return productService.getAllProduct();
    }

    @GetMapping(value = "/products/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable String id){
        return productService.getProductById(Integer.getInteger(id));
    }


    @PostMapping(value = "/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> newProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(this.productService.createProduct(product));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity < Product > updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return ResponseEntity.ok().body(productService.updateProduct(id,product));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        this.productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
