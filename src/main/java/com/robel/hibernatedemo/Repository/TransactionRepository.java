package com.robel.hibernatedemo.Repository;

import com.robel.hibernatedemo.Entities.AccountTransaction;

import java.util.List;

public interface TransactionRepository {
    List<AccountTransaction> getTransactions();

    AccountTransaction getTransaction(Long id);

    int getNumberOfTransaction();

    Long createTransaction(String description);

    int deleteTransaction(Long id);

    void updateTransaction(AccountTransaction transaction);
}
