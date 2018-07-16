package com.qa.service.business;

import com.qa.persistence.domain.Transaction;

public interface iTransactionService {
	public String addTransaction(String newTransaction);

	public String getAllTransactions();

	public Transaction findTransaction(long id);

	public String deleteTransaction(long id);

	public String updateTransaction(String newTransaction, long id);
}
