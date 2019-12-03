package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
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


    //@RequestMapping(value = "/addProduct/{name}&{description}&{quantity}&{price}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/addProduct/{id}/{name}/{description}/{quantity}/{price}")
    @ResponseStatus(HttpStatus.CREATED)
    void newProduct(@PathVariable String id,
                    @PathVariable String name,
                    @PathVariable String description,
                    @PathVariable String quantity,
                    @PathVariable String price)
    {
        productService.addProduct(id,name, description, quantity, price);
    }
}
