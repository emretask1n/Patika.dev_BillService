package com.emretaskin.BillService.bill;

import jakarta.persistence.Entity;

@Entity
public class Bill {

    private Long customerId;
    private int amount;
    private String department;

    public Bill(Long customerId, int amount, String department) {
        this.customerId = customerId;
        this.amount = amount;
        this.department = department;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "customerId=" + customerId +
                ", amount=" + amount +
                ", department='" + department + '\'' +
                '}';
    }
}
