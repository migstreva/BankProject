package com.inatel.oopbankjava.investment;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Investment {
    protected Long id;
    protected BigDecimal amount;
    protected LocalDate startDate;
    protected InvestmentAccount investmentAccount;

    public Investment(InvestmentAccount investmentAccount, BigDecimal amount, LocalDate startDate) {
        this.investmentAccount = investmentAccount;
        this.amount = amount;
        this.startDate = startDate;
    }

    public Investment() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public InvestmentAccount getInvestmentAccount() {
        return investmentAccount;
    }

    public void setInvestmentAccount(InvestmentAccount investmentAccount) {
        this.investmentAccount = investmentAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public abstract void calculateYield();
}
