package com.oopproject.model.checking;

import com.oopproject.exception.InsufficientBalanceException;

import java.math.BigDecimal;

public interface Transactable {

    void deposit(BigDecimal amount) throws InsufficientBalanceException;
    void withdraw(BigDecimal amount) throws InsufficientBalanceException;
}
