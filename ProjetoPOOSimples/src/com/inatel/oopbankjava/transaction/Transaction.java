package com.inatel.oopbankjava.transaction;

import com.inatel.oopbankjava.checking.CheckingAccount;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private Long id;
    private CheckingAccount checkingAccount;
    private TransactionType transactionType;
    private BigDecimal amount;
    private LocalDateTime timestamp;
    private BigDecimal newBalance;

    public Transaction(TransactionType transactionType, BigDecimal amount, LocalDateTime timestamp, BigDecimal newBalance) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.timestamp = timestamp;
        this.newBalance = newBalance;
    }

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CheckingAccount getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(BigDecimal newBalance) {
        this.newBalance = newBalance;
    }
}
