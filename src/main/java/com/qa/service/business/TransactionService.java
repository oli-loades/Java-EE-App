package com.qa.service.business;

import javax.inject.Inject;

import com.qa.persistence.domain.Transaction;
import com.qa.persistence.repository.iTransactionRepository;

public class TransactionService implements iTransactionService {
	@Inject
	private iTransactionRepository transactionRepo;

	public TransactionService() {
	}

	public String addTransaction(String newTransaction) {
		return transactionRepo.createTransaction(newTransaction);
	}

	public String getAllTransactions() {
		return transactionRepo.getAllTransactions();
	}

	public Transaction findTransaction(long id) {
		return transactionRepo.findTransaction(id);
	}

	public String deleteTransaction(long id) {
		return transactionRepo.deleteTransaction(id);
	}

	public String updateTransaction(String newTransaction, long id) {
		return transactionRepo.updateTransaction(id, newTransaction);
	}
}
