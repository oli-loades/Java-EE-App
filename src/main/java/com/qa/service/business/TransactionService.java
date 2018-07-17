package com.qa.service.business;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.controller.rest.AccountController;
import com.qa.persistence.domain.Transaction;
import com.qa.persistence.repository.iTransactionRepository;

public class TransactionService implements iTransactionService {
	
	private static final Logger LOGGER = Logger.getLogger(TransactionService.class);
	
	@Inject
	private iTransactionRepository transactionRepo;

	public TransactionService() {
	}

	public String addTransaction(String newTransaction) {
		LOGGER.info("transaction service create transaction");
		return transactionRepo.createTransaction(newTransaction);
	}

	public String getAllTransactions() {
		LOGGER.info("transaction service get all transactions");
		return transactionRepo.getAllTransactions();
	}

	public Transaction findTransaction(long id) {
		LOGGER.info("transaction service find transaction");
		return transactionRepo.findTransaction(id);
	}

	public String deleteTransaction(long id) {
		LOGGER.info("transaction service delete transaction");
		return transactionRepo.deleteTransaction(id);
	}

	public String updateTransaction(String newTransaction, long id) {
		LOGGER.info("transaction service update transaction");
		return transactionRepo.updateTransaction(id, newTransaction);
	}
}
