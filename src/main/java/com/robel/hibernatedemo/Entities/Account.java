package com.robel.hibernatedemo.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Account {

    @Id
    private Long accountId;
    private BigDecimal balance;
    @OneToMany(mappedBy="account")
    private List<AccountTransaction> accountTransactions;

    public Account() {
    }

    public Account(long accoundId, BigDecimal initialBalance) {
        this.accountId = accoundId;
        this.balance = initialBalance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(List<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

}
