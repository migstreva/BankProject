package com.inatel.oopbankjava.investment;

import com.inatel.oopbankjava.checking.CheckingAccount;

import java.math.BigDecimal;
import java.util.HashSet;

public class InvestmentAccount {

    private Long id;

    private CheckingAccount checkingAccount;

    private RiskProfile riskProfile;

    private HashSet<Investment> investments = new HashSet<>();

    private BigDecimal totalInvested;

    public InvestmentAccount() {
    }

    public InvestmentAccount(Long id, CheckingAccount checkingAccount, RiskProfile riskProfile) {
        this.id = id;
        this.checkingAccount = checkingAccount;
        this.riskProfile = riskProfile;
        this.investments = new HashSet<>();
        this.totalInvested = BigDecimal.ZERO;
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

    public RiskProfile getRiskProfile() {
        return riskProfile;
    }

    public void setRiskProfile(RiskProfile riskProfile) {
        this.riskProfile = riskProfile;
    }

    public HashSet<Investment> getInvestments() {
        return investments;
    }

    public void setInvestments(HashSet<Investment> investments) {
        this.investments = investments;
    }

    public BigDecimal getTotalInvested() {
        return totalInvested;
    }

    public void setTotalInvested(BigDecimal totalInvested) {
        this.totalInvested = totalInvested;
    }

    public void addInvestment(Investment investment) {
        investments.add(investment);
        totalInvested = totalInvested.add(investment.getAmount());
    }

    public void removeInvestment(Investment investment) {
        if(investments.remove(investment)) {
            totalInvested = totalInvested.subtract(investment.getAmount());
        }
    }
}
