package com.emretaskin.BillService.customer;

import com.emretaskin.BillService.bill.Bill;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    private Long customerId;
    private String customerName;
    private String customerSurname;
    private java.sql.Date createdAt;
    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Bill> bills = new ArrayList<>();

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerSurname='" + customerSurname + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public Customer(Long customerId, String customerName, String customerSurname, Date createdAt) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.createdAt = createdAt;
    }

    public Customer() {
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
