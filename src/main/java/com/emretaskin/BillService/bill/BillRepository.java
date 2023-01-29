package com.emretaskin.BillService.bill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, String> {


    @Query("SELECT b FROM Bill b WHERE b.amount > ?1")
    List<Bill> findBillsGreaterThanAmount(Integer amount);

    @Query("SELECT b FROM Bill b WHERE b.amount < ?1")
    List<Bill> findBillsLowerThanAmount(Integer amount);

    @Query("SELECT c.customerId, c.customerName, c.customerSurname, SUM(b.amount) FROM Bill b INNER JOIN Customer c ON b.customer = c.customerId GROUP BY c.customerId")
    List<String> findTotalAmountsOfCustomers();
    @Query("SELECT c.customerId, c.customerName, c.customerSurname, SUM(b.amount) FROM Bill b INNER JOIN Customer c ON b.customer = c.customerId WHERE MONTH(c.createdAt) = ?1 GROUP BY c.customerId")
    List<String> findTotalAmountsOfCustomersSignedInASpecificMonth(Integer amount);

    @Query("SELECT b.company, b.department, SUM(b.amount) FROM Bill b GROUP BY b.department")
    List<String> findAmountsGroupByDepartments();

    @Query("SELECT b.company, b.department, SUM(b.amount) FROM Bill b WHERE SUM(b.amount) < ?1 GROUP BY b.department")
    List<String> findLessAmountsThanGivenAmountAndGroupByDepartments(Integer amount);




}
