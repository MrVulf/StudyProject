package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/test")
public class TestProductController {
    @Autowired
    private ProductService productService;

    private static final Logger LOG = LoggerFactory.getLogger(TestProductController.class);

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Product> getAllCountries() {

        LOG.info("==== TEST TEST TEST =====");
        return productService.getAll();
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Optional<Product> getProductById(@PathVariable String id){
        return productService.getProductById(Long.parseLong(id));
    }
}
