package com.qa.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;

import com.qa.persistence.domain.Account;
import com.qa.persistence.util.JSONUtility;

@Transactional(SUPPORTS)
public class AccountRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	private JSONUtility util;

	public List<Account> getAllAccounts() {
		Query query = em.createQuery("Select * FROM ACCOUNT");
		return query.getResultList();
	}
	
	public Account findAnAccount(long id) {
		return em.find(Account.class, id);
	}
	
	@Transactional(REQUIRED)
	public void createAnAccount(String accoutnString) {
		Account account = util.getObjectForJSON(accoutnString, Account.class);
		em.persist(account);
	}
	
	@Transactional(REQUIRED)
	public void updateAnAccount(String accountString,long id) {
		Account updatedAccount = util.getObjectForJSON(accountString, Account.class);
		Account account = findAnAccount(id);
		if(account != null) {
			account = updatedAccount;
			em.merge(account);
		}
	}
	
	@Transactional(REQUIRED)
	public void deleteAccount(long id) {
		Account account = findAnAccount(id);
		if (account != null) {
			em.remove(account);
		}
	}
}
