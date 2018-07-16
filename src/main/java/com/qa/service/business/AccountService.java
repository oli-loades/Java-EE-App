package com.qa.service.business;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.iAccountRepository;

public class AccountService {

	@Inject
	private iAccountRepository accRepo;

	@Inject
	private iAccountValidator validator;
	
	public AccountService() {}

	public String addAccount(String account) {
		String returnMsg;
		if(validator.isValid(account)) {
			returnMsg = accRepo.createAnAccount(account);
		}else {
			returnMsg = "{\"message\": \"account blocked\"}";	
		}
		return returnMsg;
	}

	public Account getAccount(long id) {
		return accRepo.findAnAccount(id);
	}

	public String deleteAccount(long id) {
		return accRepo.deleteAccount(id);
	}

	public String updateAccount(long id, String newAcount) {
		String returnMsg;
		if(validator.isValid(newAcount)) {
			returnMsg = accRepo.updateAnAccount(newAcount, id);
		}else {
			returnMsg = "{\"message\": \"account blocked\"}";	
		}
		return returnMsg;
	}

	public String getAllAccounts() {
		return accRepo.getAllAccounts();
	}
}
