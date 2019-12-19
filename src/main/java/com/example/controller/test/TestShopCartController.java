package com.example.controller.test;

import com.example.impl.OrdAndProdDbServiceImpl;
import com.example.impl.OrderDbServiceImpl;
import com.example.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/test")
public class TestShopCartController {

    private OrderDbServiceImpl ordRepos;
    private OrdAndProdDbServiceImpl ordProdRepos;

    @PostMapping("/putOrder")
    public String putOrder(@RequestBody Order order){
        ordRepos.putInDb(order);
        ordProdRepos.putInDb(order);
        return "DID";
    }
}
