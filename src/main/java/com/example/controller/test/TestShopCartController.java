package com.example.controller.test;

import com.example.exception.NotEnoughProductsInStockException;
import com.example.exception.NotProductsInShopCartException;
import com.example.impl.OrderServiceImpl;
import com.example.impl.OrderedProductServiceImpl;
import com.example.impl.ShopCartServiceImpl;
import com.example.model.Order;
import com.example.model.Product;
import com.example.model.SelectedProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/test/shop-cart")
public class TestShopCartController {
    @Autowired
    private ShopCartServiceImpl cartService;
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private OrderedProductServiceImpl orderedProductService;

    @GetMapping("/current-prod")
    @ResponseStatus(code = HttpStatus.FOUND)
    @ResponseBody
    public List<SelectedProduct> getAllProduct(){
        return cartService.getProductsInCart();
    }

    @GetMapping("/get-total")
    @ResponseBody
    public Double getTotal(){
        return cartService.getTotal();
    }

    @PostMapping("/add-prod")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<Product> putProduct(@RequestBody Product product){
        return ResponseEntity.ok(cartService.addProduct(product));
    }

    @PostMapping("/checkout/{id}")
    @ResponseBody
    public Order finishOrder(@PathVariable Integer id)
    {
        Order order = orderService.makeOrder(id, new Date(), cartService.getShopCart());
        orderService.addOrderInDB(order);
        orderedProductService.addDetailInDB(order);
        return order;
    }

    @PutMapping("/remove-prod")
    @ResponseBody
    public void removeProd(@RequestBody Product product){
        cartService.removeProduct(product);
    }
}
