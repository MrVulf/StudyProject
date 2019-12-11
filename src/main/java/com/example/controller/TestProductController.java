package com.example.controller;

import com.example.implementation.ProductServiceImpl;
import com.example.model.Product;
import com.example.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@Controller
@RequestMapping("/test")
public class TestProductController {

    private final ProductServiceImpl productService;

    private static final Logger LOG = LoggerFactory.getLogger(TestProductController.class);

    @Autowired
    public TestProductController(ProductService productService, ProductServiceImpl productService1) {
        this.productService = productService1;
        LOG.info("==== TEST FROM constructor =====");
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Product> getAllProducts() {
        LOG.info("==== TEST FROM getAllCountries =====");
        return productService.getAllProduct();
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Product getProductById(@PathVariable String id){
        return productService.getProductById(Integer.getInteger(id));
    }


    @RequestMapping(value = "/products", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> newProduct(@RequestBody Product product) {
        LOG.info("==== TEST FROM newProduct =====");
        return ResponseEntity.ok().body(this.productService.createProduct(product));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity < Product > updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        product.setId(id);
        return ResponseEntity.ok().body(this.productService.updateProduct(product));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        this.productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}



//@PostMapping("/addProduct")