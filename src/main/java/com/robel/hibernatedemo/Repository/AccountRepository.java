package com.robel.hibernatedemo.Repository;

import com.robel.hibernatedemo.Entities.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository {
    List<Account> getAccounts();

    Account getAccount(Long id);

    int getNumberOfAccounts();

    Long createAccount(BigDecimal initialBalance);

    int deleteAccount(Long id);

    void updateAccount(Account account);
}
