package com.inatel.oopbankjava.investment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;

public class FixedIncome extends Investment {

    private FixedIncomeType fixedIncomeType;
    private BigDecimal dailyPeriodicRate;
    private BigDecimal taxRate;
    private BigDecimal yield;

    @Override
    public void calculateYield() {
        int daysInvested = LocalDate.now().getDayOfYear() - startDate.getDayOfYear();

        BigDecimal totalInterest = dailyPeriodicRate.pow(daysInvested);

        BigDecimal yieldBeforeTax = amount.multiply(totalInterest)
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal totalTax = yieldBeforeTax.multiply(taxRate);

        yield = yieldBeforeTax.subtract(totalTax);
    }

    public FixedIncome() {
    }

    public FixedIncome(InvestmentAccount investmentAccount, BigDecimal amount, FixedIncomeType type, BigDecimal dailyPeriodicRate, BigDecimal taxRate) {
        super(investmentAccount, amount, LocalDate.now(ZoneId.of("America/Sao_Paulo")));
        this.fixedIncomeType = type;
        this.dailyPeriodicRate = dailyPeriodicRate;
        this.taxRate = taxRate;
    }

    public FixedIncomeType getFixedIncomeType() {
        return fixedIncomeType;
    }

    public void setFixedIncomeType(FixedIncomeType fixedIncomeType) {
        this.fixedIncomeType = fixedIncomeType;
    }

    public BigDecimal getDailyPeriodicRate() {
        return dailyPeriodicRate;
    }

    public void setDailyPeriodicRate(BigDecimal dailyPeriodicRate) {
        this.dailyPeriodicRate = dailyPeriodicRate;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getYield() {
        return yield;
    }
}
