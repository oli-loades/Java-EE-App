package com.qa.persistence.repository;

import java.util.Collection;

import com.qa.persistence.domain.Account;

public interface iAccountRepository {

	Account findAnAccount(long id);

	String getAllAccounts();

	String createAnAccount(String accoutnString);

	String updateAnAccount(String accountString, long id);

	String deleteAccount(long id);

}
