package com.emretaskin.BillService.bill;

import com.emretaskin.BillService.customer.Customer;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Bill")
public class Bill {

    @Id
    private Long billId;
    private Integer amount;
    private String department;
    private String company;
    private java.sql.Date billCreatedAt;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Bill(Long billId, Integer amount, String department, String company, Date billCreatedAt, Customer customer) {
        this.billId = billId;
        this.amount = amount;
        this.department = department;
        this.company = company;
        this.billCreatedAt = billCreatedAt;
        this.customer = customer;
    }

    public Bill() {
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getBillCreatedAt() {
        return billCreatedAt;
    }

    public void setBillCreatedAt(Date billCreatedAt) {
        this.billCreatedAt = billCreatedAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId='" + billId + '\'' +
                ", amount=" + amount +
                ", department='" + department + '\'' +
                ", company='" + company + '\'' +
                ", billCreatedAt=" + billCreatedAt +
                ", customer=" + customer +
                '}';
    }
}
