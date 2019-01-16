package com.robel.hibernatedemo.Repository;

import com.robel.hibernatedemo.Entities.AccountTransaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaTransactionRepository implements TransactionRepository {
    private long nextId = 1;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<AccountTransaction> getTransactions() {
        return entityManager.createQuery("select a from AccountTransaction a")
                .getResultList();

    }

    @Override
    public AccountTransaction getTransaction(Long id) {
        return entityManager.find(AccountTransaction.class, id);
    }

    @Override
    public int getNumberOfTransaction() {
        Long result = (Long) entityManager.
                createQuery("select count(a.id) from AccountTransaction a")
                .getSingleResult();
        return 0;
    }

    @Override
    public Long createTransaction(String description) {
        long id = nextId++;
        entityManager.persist(new AccountTransaction(id, description));
        return id;
    }

    @Override
    public int deleteTransaction(Long id) {
        entityManager.remove(getTransaction(id));
        return 1;
    }

    @Override
    public void updateTransaction(AccountTransaction transaction) {
        entityManager.merge(transaction);
    }
}
