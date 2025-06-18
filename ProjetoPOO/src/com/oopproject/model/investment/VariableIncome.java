package com.oopproject.model.investment;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VariableIncome extends Investment{

    @Override
    public BigDecimal calculateYield() {
        return null;
    }

    public VariableIncome(String name, BigDecimal amount, LocalDate startDate) {
        super(name, amount, startDate);
    }
}
