package com.lukpheakdey.orderservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class OrderController {

    private List<Order> orders = Arrays.asList(
            new Order(1, 1, "001 iPhone"),
            new Order(2,1, "002 Mac Book M1"),
            new Order(3, 2, "003 iWatch"),
            new Order(4,2, "Air Tag"));


    @GetMapping
    public List<Order> getAllOrders(){
        return orders;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id){
        return orders.stream()
                .filter(order -> order.getId()==id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
