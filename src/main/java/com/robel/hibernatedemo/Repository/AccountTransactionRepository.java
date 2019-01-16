package com.robel.hibernatedemo.Repository;

import com.robel.hibernatedemo.Entities.AccountTransaction;
import org.springframework.data.repository.CrudRepository;

public interface AccountTransactionRepository extends CrudRepository<AccountTransaction,Long> {
}
