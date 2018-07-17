package com.qa.persistence.repository;

import javax.enterprise.context.ApplicationScoped;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import com.qa.persistence.domain.Account;
import com.qa.persistence.util.JSONUtility;

@ApplicationScoped
@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements iAccountRepository {
	
	private static final Logger LOGGER = Logger.getLogger(AccountDBRepository.class);

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtility util;

	public AccountDBRepository() {
	}

	public String getAllAccounts() {
		LOGGER.info("account DB repository get all accounts");
		return util.getJSONForObject(em.createQuery("SELECT a FROM Account a").getResultList());
	}

	public Account findAnAccount(long id) {
		LOGGER.info("account DB repository find account");
		return em.find(Account.class, id);
	}

	@Transactional(REQUIRED)
	public String createAnAccount(String accoutnString) {
		LOGGER.info("account DB repository create account");
		Account account = util.getObjectForJSON(accoutnString, Account.class);
		em.persist(account);
		return "{\"message\": \"account sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateAnAccount(String accountString, long id) {
		LOGGER.info("account DB repository update account");
		Account updatedAccount = util.getObjectForJSON(accountString, Account.class);
		Account account = findAnAccount(id);
		if (account != null) {
			account.setAccNo(updatedAccount.getAccNo());
			account.setFirstName(updatedAccount.getFirstName());
			account.setSurname(updatedAccount.getSurname());
			em.merge(account);
		}
		return "{\"message\": \"account sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteAccount(long id) {
		LOGGER.info("account DB repository delete account");
		Account account = findAnAccount(id);
		if (account != null) {
			em.remove(account);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public JSONUtility getUtil() {
		return util;
	}

	public void setUtil(JSONUtility util) {
		this.util = util;
	}
}
