package com.qa.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;

import com.qa.persistence.domain.Account;

@Transactional(SUPPORTS)
public class AccountRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	public List<Account> getAllAccounts() {
		Query query = em.createQuery("Select * FROM ACCOUNT");
		List<Account> results = query.getResultList();
		return results;
	}
	
	public Account findAnAccount(long id) {
		return em.find(Account.class, id);
	}
	
	@Transactional(REQUIRED)
	public void createAnAccount(Account account) {
		
	}
	
	@Transactional(REQUIRED)
	public void updateAnAccount(long id) {
		
	}
	
	@Transactional(REQUIRED)
	public void deleteAccount(long id) {
		Account account = findAnAccount(id);
		if (account != null) {
			em.remove(account);
		}
	}
}
