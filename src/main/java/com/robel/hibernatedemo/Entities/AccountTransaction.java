package com.robel.hibernatedemo.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AccountTransaction {
    @Id
    private Long transactionId;
    @ManyToOne
    @JoinColumn(name="accountId", nullable=false)
    private Account account;
    private String description;

    public AccountTransaction() {
    }

    public AccountTransaction(long id, String description) {
        this.transactionId = id;
        this.description = description;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
