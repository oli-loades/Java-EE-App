package com.qa.service.business;

import com.qa.persistence.domain.Account;

public interface iAccountService {
	public String addAccount(String account);

	public Account getAccount(long id);

	public String deleteAccount(long id);

	public String updateAccount(long id, String newAcount);

	public String getAllAccounts();
}
