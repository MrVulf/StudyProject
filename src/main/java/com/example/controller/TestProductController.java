package com.example.controller;

import com.example.implementation.ProductServiceImpl;
import com.example.model.Product;
import com.example.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public Collection<Product> getAllCountries() {
        LOG.info("==== TEST FROM getAllCountries =====");
        return productService.getProducts();
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Product getProductById(@PathVariable String id){
        return productService.getProduct(id);
    }


    @RequestMapping(value = "/addProduct/{name}/{description}/{quantity}/{price}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    //@PostMapping("/addProduct/{name}/{description}/{quantity}/{price}")
    @ResponseStatus(HttpStatus.CREATED)
    void newProduct(@PathVariable String name,
                    @PathVariable String description,
                    @PathVariable String quantity,
                    @PathVariable String price)
    {
        LOG.info("==== TEST FROM addProduct =====");
        Product newProduct = new Product(name, description, Integer.getInteger(quantity), Double.valueOf(price));
        LOG.info("==== TEST FROM addProduct :: make instance Product =====");
        productService.createProduct(newProduct);
    }
}
