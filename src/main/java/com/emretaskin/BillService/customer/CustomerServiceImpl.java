package com.emretaskin.BillService.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{


    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> fetchCustomerList() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getCustomersWithSpecificLetter(String letter) {
        return customerRepository.findByLetterContains(letter);
    }

    @Override
    public List<String> fetchCustomersWithLowerAmountThanGivenAmount(Integer amount) {
        if (amount==null){
            return customerRepository.findListOfCustomersWithAmounts();
        }else {
            return customerRepository.findListOfCustomersWhoHasLessTotalAmountThanGivenAmount(amount);
        }    }

}
