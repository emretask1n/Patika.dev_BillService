package com.emretaskin.BillService.bill;

import com.emretaskin.BillService.customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Bill")
public class Bill {

    @Id
    private Long billId;
    private Integer amount;
    private String department;
    private String company;
    private java.util.Date billCreatedAt = new java.util.Date();
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
