package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Transaction;
import com.qa.persistence.util.JSONUtility;

@ApplicationScoped
@Transactional(SUPPORTS)
public class TransactionRepository {
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtility util;
	
	public Transaction findTransaction(long id) {
		return em.find(Transaction.class, id);
	}
	
	public String getAllTransactions() {
		return util.getJSONForObject(em.createQuery("SELECT t FROM Transaction t").getResultList());
	}
	
	@Transactional(REQUIRED)
	public String createTransaction(String transaction) {
		Transaction newTransaction = util.getObjectForJSON(transaction, Transaction.class);
		em.persist(newTransaction);
		return "{\"message\": \"transaction sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateTransaction(long id, String transaction) {
		Transaction newTransaction = util.getObjectForJSON(transaction, Transaction.class);
		Transaction toUpdate = findTransaction(id);
		if(toUpdate != null) {
			toUpdate.setAccountId(newTransaction.getAccountId());
			toUpdate.setName(newTransaction.getName());
			em.merge(toUpdate);
		}
		return "{\"message\": \"transaction sucessfully updated\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteTransaction(long id) {
		Transaction transaction = findTransaction(id);
		if (transaction != null) {
			em.remove(transaction);
		}
		return "{\"message\": \"transaction sucessfully deleted\"}";
	}
}
