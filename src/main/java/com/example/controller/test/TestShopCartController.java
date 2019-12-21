package com.example.controller.test;

import com.example.exception.NotEnoughProductsInStockException;
import com.example.exception.NotProductsInShopCartException;
import com.example.impl.ShopCartServiceImpl;
import com.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/test/shop_cart")
public class TestShopCartController {

    @Autowired
    private ShopCartServiceImpl service;

    @GetMapping("/current_prod")
    @ResponseStatus(code = HttpStatus.FOUND)
    @ResponseBody
    public Map<Product,Integer> getAllProduct(){
        return service.getProductsInCart();
    }

    @GetMapping("/get_total")
    @ResponseBody
    public String getTotal(){
        return "Your total sum is " + service.getTotal();
    }

    @PostMapping("/put_prod")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    public String putProduct(@RequestBody Product product){
        service.addProduct(product);
        return "You put " + product.getName() + " successfully";
    }

    @PostMapping("/checkout/{id}")
    @ResponseBody
    public String finishOrder(@PathVariable Integer id) {
        try {
            service.checkout(id);
        }
        catch (NotEnoughProductsInStockException e){
            return "We don't have enough number of products :(";
        }
        catch (NotProductsInShopCartException e){
            return "You don't have products in shop cart :(";
        }
        return "Order made successfully";
    }

    @PutMapping("/remove_prod")
    @ResponseBody
    public String removeProd(@RequestBody Product product){
        service.removeProduct(product);
        return "Removed successfully";
    }

}
