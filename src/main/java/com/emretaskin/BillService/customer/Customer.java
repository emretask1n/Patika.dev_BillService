package com.emretaskin.BillService.customer;

import com.emretaskin.BillService.bill.Bill;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Customer")
public class Customer {

    @Id
    private Long customerId;
    private String customerName;
    private String customerSurname;
    private java.util.Date createdAt = new java.util.Date();
    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Bill> bills = new ArrayList<>();
}
