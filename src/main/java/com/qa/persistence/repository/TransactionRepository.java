package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Transaction;
import com.qa.persistence.util.JSONUtility;

@ApplicationScoped
@Transactional(SUPPORTS)
public class TransactionRepository implements iTransactionRepository {
	
	private static final Logger LOGGER = Logger.getLogger(TransactionRepository.class);
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtility util;

	public Transaction findTransaction(long id) {
		LOGGER.info("Transaction Repository find transaction");
		return em.find(Transaction.class, id);
	}

	public String getAllTransactions() {
		LOGGER.info("Transaction Repository get all  transactions");
		return util.getJSONForObject(em.createQuery("SELECT t FROM Transaction t").getResultList());
	}

	@Transactional(REQUIRED)
	public String createTransaction(String transaction) {
		LOGGER.info("Transaction Repository create transaction");
		Transaction newTransaction = util.getObjectForJSON(transaction, Transaction.class);
		em.persist(newTransaction);
		return "{\"message\": \"transaction sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateTransaction(long id, String transaction) {
		LOGGER.info("Transaction Repository update transaction");
		Transaction newTransaction = util.getObjectForJSON(transaction, Transaction.class);
		Transaction toUpdate = findTransaction(id);
		if (toUpdate != null) {
			toUpdate.setAccountId(newTransaction.getAccountId());
			toUpdate.setName(newTransaction.getName());
			em.merge(toUpdate);
		}
		return "{\"message\": \"transaction sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteTransaction(long id) {
		LOGGER.info("Transaction Repository delete transaction");
		Transaction transaction = findTransaction(id);
		if (transaction != null) {
			em.remove(transaction);
		}
		return "{\"message\": \"transaction sucessfully deleted\"}";
	}
}
