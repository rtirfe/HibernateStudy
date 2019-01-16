package com.robel.hibernatedemo.services;

import com.robel.hibernatedemo.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository repository;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public String getDescription(Long id){
        return repository.getTransaction(id).getDescription();
    }
}
