package com.lukpheakdey.customerservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {

    private List<Customer> customers = Arrays.asList(new Customer(1, "Pheakdey"), new Customer(2, "David"));

    @GetMapping
    public List<Customer> getAllCustomers(){
        return  customers;
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id){
        return customers.stream()
                .filter(customer -> customer.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
