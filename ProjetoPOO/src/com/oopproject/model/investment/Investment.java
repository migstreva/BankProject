package com.oopproject.model.investment;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Investment {
    private String name;
    private BigDecimal amount;
    private LocalDate startDate;

    public Investment(String name, BigDecimal amount, LocalDate startDate) {
        this.name = name;
        this.amount = amount;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public abstract BigDecimal calculateYield();
}
