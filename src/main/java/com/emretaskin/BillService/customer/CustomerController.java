package com.emretaskin.BillService.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class CustomerController {


    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> saveCustomer (@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.saveCustomer(customer), OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> fetchCustomerList(@RequestParam(value = "letter", required = false) String letter){
        if (letter == null) {
            return new ResponseEntity<>(customerService.fetchCustomerList(), OK);
        }else{
            return new ResponseEntity<>(customerService.getCustomersWithSpecificLetter(letter), OK);
        }
    }

    @GetMapping("/customers/lower")
    public ResponseEntity<List<String>> fetchBillsGreaterThanAmount(@RequestParam(value = "amount", required = false) Integer amount){
        return new ResponseEntity<>(customerService.fetchCustomersWithLowerAmountThanGivenAmount(amount),OK);
    }
}
