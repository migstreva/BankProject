package com.inatel.oopbankjava.investment;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;

public class VariableIncome extends Investment {

    private String tickerSymbol; // e.g., "AAPL" or "PETR4.SA"
    private BigDecimal yield;

    public VariableIncome(InvestmentAccount investmentAccount, String tickerSymbol, BigDecimal amount) {
        super(investmentAccount, amount, LocalDate.now(ZoneId.of("America/Sao_Paulo")));
        this.tickerSymbol = tickerSymbol;
    }

    public VariableIncome() {
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    @Override
    public void calculateYield() {
        try {
            Stock stock = YahooFinance.get(tickerSymbol);
            BigDecimal currentPrice = stock.getQuote().getPrice();

            if (currentPrice == null) {
                throw new RuntimeException("Could not fetch price for " + tickerSymbol);
            }

            yield = currentPrice.subtract(getAmount());

        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch stock data for: " + tickerSymbol, e);
        }
    }

    public BigDecimal getYield() {
        return yield;
    }
}
