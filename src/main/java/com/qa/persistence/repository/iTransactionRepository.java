package com.qa.persistence.repository;

import com.qa.persistence.domain.Transaction;

public interface iTransactionRepository {
	public Transaction findTransaction(long id);

	public String getAllTransactions();

	public String createTransaction(String transaction);

	public String updateTransaction(long id, String transaction);

	public String deleteTransaction(long id);
}
