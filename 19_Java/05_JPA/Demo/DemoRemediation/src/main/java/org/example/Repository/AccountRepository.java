package org.example.Repository;

import org.example.Entity.Account;

import javax.persistence.EntityManager;
import java.util.List;

public class AccountRepository extends BaseRepository<Account> {
    public AccountRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Account findById(int id) {
        return em.find(Account.class,id);
    }

    @Override
    public List<Account> findALl() {
        return em.createQuery("select a from Account a").getResultList();
    }
}
