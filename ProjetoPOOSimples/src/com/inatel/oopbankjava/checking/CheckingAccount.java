package com.inatel.oopbankjava.checking;

import com.inatel.oopbankjava.customer.Customer;
import com.inatel.oopbankjava.transaction.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CheckingAccount {

    private Long accountNumber;
    private Customer customer;
    private Integer bankBranch;
    private Boolean isActive;
    private LocalDate createdAt;
    private BigDecimal balance;
    private List<Transaction> transactions = new ArrayList<>();

    public CheckingAccount(Long accountNumber, Customer customer, Integer bankBranch) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.bankBranch = bankBranch;
        this.isActive = true;
        this.createdAt = LocalDate.now();
        this.balance = BigDecimal.ZERO;
    }

    public List<Transaction> getTransactions() {
        return transactions;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
