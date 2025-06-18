package com.oopproject.model.checking;

import com.oopproject.exception.InsufficientBalanceException;
import com.oopproject.model.Account;
import com.oopproject.model.customer.Customer;

import java.math.BigDecimal;

public class CheckingAccount extends Account implements Transactable {

    public CheckingAccount(Long accountNumber, Customer customer, Integer bankBranch) {
        super(accountNumber, customer, bankBranch);
    }

    @Override
    public void deposit(BigDecimal amount) throws InsufficientBalanceException {
        //TODO
    }

    @Override
    public void withdraw(BigDecimal amount) throws InsufficientBalanceException {
        //TODO
    }


}
