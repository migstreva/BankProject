package com.oopproject.model;

import com.oopproject.model.customer.Customer;

import java.time.LocalDate;

public abstract class Account {
    private final Long accountNumber;
    private final Customer customer;
    private final Integer bankBranch;
    private boolean isActive;
    private final LocalDate createdAt;

    public Account(Long accountNumber, Customer customer, Integer bankBranch) {
        if (accountNumber == null || accountNumber <= 0)
            throw new IllegalArgumentException("Invalid account number");

        if (customer == null)
            throw new IllegalArgumentException("Customer cannot be null");

        if (bankBranch == null || bankBranch <= 0)
            throw new IllegalArgumentException("Invalid bank branch");

        this.accountNumber = accountNumber;
        this.customer = customer;
        this.bankBranch = bankBranch;
        this.isActive = true;
        this.createdAt = LocalDate.now();
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Integer getBankBranch() {
        return bankBranch;
    }

    public boolean isActive() {
        return isActive;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void closeAccount() {
        this.isActive = false;
    }

    public void openAccount() {
        this.isActive = true;
    }
}
