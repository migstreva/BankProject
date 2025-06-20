package com.inatel.oopbankjava;

import com.inatel.oopbankjava.exception.InsufficientBalanceException;

import java.math.BigDecimal;

public interface Transactable {

    void deposit(BigDecimal amount, Long accountId);

    void withdraw(BigDecimal amount, Long accountId) throws InsufficientBalanceException;

    void transfer(BigDecimal amount, Long fromAccountId, Long toAccountId) throws InsufficientBalanceException;
}
