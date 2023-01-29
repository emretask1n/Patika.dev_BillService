package com.emretaskin.BillService.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    @Query("SELECT c FROM Customer c WHERE c.customerName LIKE %?1%")
    List<Customer> findByLetterContains(String letter);

    @Query("SELECT c.customerId, c.customerName, c.customerSurname, SUM(b.amount) FROM Bill b INNER JOIN Customer c ON b.customer = c.customerId WHERE SUM(b.amount) < ?1 GROUP BY c.customerId")
    List<String> findListOfCustomersWhoHasLessTotalAmountThanGivenAmount(Integer amount);

    @Query("SELECT c.customerId, c.customerName, c.customerSurname, SUM(b.amount) FROM Bill b INNER JOIN Customer c ON b.customer = c.customerId GROUP BY c.customerId")
    List<String> findListOfCustomersWithAmounts();


}
