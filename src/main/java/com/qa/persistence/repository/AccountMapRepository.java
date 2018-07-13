package com.qa.persistence.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.util.JSONUtility;

@ApplicationScoped
@Alternative
public class AccountMapRepository implements iAccountRepository {

	private Map<Long, Account> accountMap;

	@Inject
	private JSONUtility util;

	private long id;

	public AccountMapRepository() {
		id = 1;
		accountMap = new HashMap<Long, Account>();
	}

	public String getAllAccounts() {
		return util.getJSONForObject(accountMap.values());
	}

	public String createAnAccount(String accoutnString) {
		Account account = util.getObjectForJSON(accoutnString, Account.class);
		String returnMsg;
		if(account.getAccNo().equals("9999")) {
			returnMsg = "{\"message\": \"account blocked\"}";
		}else {
			accountMap.put(id, account);
			id++;
			returnMsg = "{\"message\": \"account sucessfully added\"}";
		}
	
		return returnMsg;
	}

	public String updateAnAccount(String accountString, long id) {
		Account updatedAccount = util.getObjectForJSON(accountString, Account.class);
		accountMap.put(id, updatedAccount);
		return "{\"message\": \"account sucessfully updated\"}";
	}

	public String deleteAccount(long id) {
		accountMap.remove(id);
		return "{\"message\": \"account sucessfully deleted\"}";
	}

	public Account findAnAccount(long id) {
		return accountMap.get(id);
	}

}
