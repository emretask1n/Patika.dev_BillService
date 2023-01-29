package com.emretaskin.BillService.customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);

    List<Customer> fetchCustomerList();

    List<Customer> getCustomersWithSpecificLetter(String letter);

    List<String> fetchCustomersWithLowerAmountThanGivenAmount(Integer amount);
}
