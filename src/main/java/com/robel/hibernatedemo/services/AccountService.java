package com.robel.hibernatedemo.services;

import com.robel.hibernatedemo.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service @Transactional
public class AccountService {
    @Autowired
    AccountRepository repository;
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public BigDecimal getBalance(Long id) {
        return repository.getAccount(id).getBalance();
    }

}
