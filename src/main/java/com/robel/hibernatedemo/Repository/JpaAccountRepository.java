package com.robel.hibernatedemo.Repository;

import com.robel.hibernatedemo.Entities.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class JpaAccountRepository implements AccountRepository{

    private long nextId = 4;

    //Both the org.hibernate.Session API and javax.persistence.EntityManager API
    // represent a context for dealing with persistent data.
    // This concept is called a persistence contex
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Account> getAccounts() {
        return entityManager.createQuery("select a from Account a", Account.class)
                .getResultList();
    }

    @Override
    public Account getAccount(Long id) {
        return entityManager.find(Account.class, id);
    }

    @Override
    public int getNumberOfAccounts() {
        Long result =(Long) entityManager.createQuery("select count(a.id) from Account a").getSingleResult();

        return result.intValue();
    }

    @Override
    public Long createAccount(BigDecimal initialBalance) {
        long id = nextId++;
        entityManager.persist(new Account(id, initialBalance));
        return id;
    }

    @Override
    public int deleteAccount(Long id) {
        entityManager.remove(getAccount(id));
        return 1;
    }

    @Override
    public void updateAccount(Account account) {
        entityManager.merge(account);
    }

}
