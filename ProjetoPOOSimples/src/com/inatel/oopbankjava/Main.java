package com.inatel.oopbankjava;

import com.inatel.oopbankjava.checking.CheckingAccount;
import com.inatel.oopbankjava.customer.Address;
import com.inatel.oopbankjava.customer.Customer;
import com.inatel.oopbankjava.customer.DocumentType;
import com.inatel.oopbankjava.customer.Occupation;
import com.inatel.oopbankjava.exception.InsufficientBalanceException;
import com.inatel.oopbankjava.investment.*;
import com.inatel.oopbankjava.transaction.Transaction;
import com.inatel.oopbankjava.transaction.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        // Criar endereço
        Address address = new Address();
        address.setStreet("Rua Silvestre Ferraz");
        address.setNumber(543);
        address.setCity("Santa Rita");
        address.setState("Minas Gerais");
        address.setZip("37540000");

        // Criar cliente
        Customer customer = new Customer();
        customer.setFullName("Douglas Otani");
        customer.setDocumentNumber("987655665");
        customer.setDocumentType(DocumentType.CPF);
        customer.setEmail("douglas.otani@gmail.com");
        customer.setPhone("88776776676");
        customer.setDateOfBirth(java.time.LocalDate.of(2002, 11, 16));
        customer.setOccupation(Occupation.CIVIL_ENGINEER);
        customer.setAddress(address);

        // Criar conta corrente
        CheckingAccount checkingAccount = new CheckingAccount(1L, customer, 99);

        // Depositar 500 reais
        deposit(checkingAccount, new BigDecimal("500.00"));
        System.out.println("Saldo após depósito: " + checkingAccount.getBalance());

        // Sacar 200 reais
        try {
            withdraw(checkingAccount, new BigDecimal("200.00"));
            System.out.println("Saldo após saque: " + checkingAccount.getBalance());
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        // Tentar sacar valor maior que saldo para ver exceção
        try {
            withdraw(checkingAccount, new BigDecimal("400.00"));
        } catch (InsufficientBalanceException e) {
            System.out.println("Erro ao sacar: " + e.getMessage());
        }

        // Criar conta investimento associada
        InvestmentAccount investmentAccount = new InvestmentAccount(1L, checkingAccount, RiskProfile.MODERATE);

        // Criar investimento renda fixa
        FixedIncome fixedIncome = new FixedIncome(
                investmentAccount,
                new BigDecimal("1000.00"),
                FixedIncomeType.CDB,
                new BigDecimal("1.01"), // taxa periódica diária (1%)
                new BigDecimal("0.15")  // taxa de imposto 15%
        );
        fixedIncome.calculateYield();

        // Adicionar investimento à conta investimento
        investmentAccount.addInvestment(fixedIncome);

        System.out.println("Investimentos na conta:");
        for (Investment inv : investmentAccount.getInvestments()) {
            System.out.println(inv.getClass().getSimpleName() + " - Valor: " + inv.getAmount());
            if (inv instanceof FixedIncome) {
                System.out.println("Yield aproximado: " + ((FixedIncome) inv).getYield());
            }
        }
    }

    private static void deposit(CheckingAccount account, BigDecimal amount) {
        BigDecimal newBalance = account.getBalance().add(amount);
        account.setBalance(newBalance);

        Transaction transaction = new Transaction(TransactionType.DEPOSIT, amount, LocalDateTime.now(), newBalance);
        transaction.setCheckingAccount(account);
        account.addTransaction(transaction);
    }

    private static void withdraw(CheckingAccount account, BigDecimal amount) throws InsufficientBalanceException {
        if (account.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException();
        }
        BigDecimal newBalance = account.getBalance().subtract(amount);
        account.setBalance(newBalance);

        Transaction transaction = new Transaction(TransactionType.WITHDRAWAL, amount, LocalDateTime.now(), newBalance);
        transaction.setCheckingAccount(account);
        account.addTransaction(transaction);
    }
}
