package com.emretaskin.BillService.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public Customer saveCustomer (@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> fetchCustomerList(){
        return customerService.fetchCustomerList();
    }


    @GetMapping("/customers/{letter}")
    public List<Customer> getCustomersWithSpecificLetter(@PathVariable String letter){
        return customerService.getCustomersWithSpecificLetter(letter);
    }
}
