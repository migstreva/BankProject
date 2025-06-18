package com.oopproject.model.investment;

import com.oopproject.model.Account;
import com.oopproject.model.customer.Customer;

import java.math.BigDecimal;
import java.util.HashSet;

public class InvestmentAccount extends Account {

    HashSet<Investment> investments;
    BigDecimal totalYield;

    public InvestmentAccount(Long accountNumber, Customer customer, Integer bankBranch, HashSet<Investment> investments) {
        super(accountNumber, customer, bankBranch);
        this.investments = investments;
    }


}
