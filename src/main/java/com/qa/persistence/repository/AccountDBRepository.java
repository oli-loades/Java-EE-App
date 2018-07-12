package com.qa.persistence.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import com.qa.persistence.domain.Account;
import com.qa.persistence.util.JSONUtility;

@ApplicationScoped
@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements iAccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtility util;

	public String getAllAccounts() {
		Query query = em.createQuery("Select * FROM ACCOUNT");
		return util.getJSONForObject(query.getResultList());
	}

	public Account findAnAccount(long id) {
		return em.find(Account.class, id);
	}

	@Transactional(REQUIRED)
	public String createAnAccount(String accoutnString) {
		Account account = util.getObjectForJSON(accoutnString, Account.class);
		em.persist(account);
		return "{\"message\": \"account sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateAnAccount(String accountString, long id) {
		Account updatedAccount = util.getObjectForJSON(accountString, Account.class);
		Account account = findAnAccount(id);
		if (account != null) {
			account = updatedAccount;
			em.merge(account);
		}
		return "{\"message\": \"account sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteAccount(long id) {
		Account account = findAnAccount(id);
		if (account != null) {
			em.remove(account);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}
}
