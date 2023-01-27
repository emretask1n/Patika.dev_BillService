package com.emretaskin.BillService.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {




    @Query("SELECT c FROM Customer c WHERE c.customerName LIKE %?1%")
    List<Customer> findByContentContains(String letter);


}
