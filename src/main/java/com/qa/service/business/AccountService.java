package com.qa.service.business;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.iAccountRepository;

public class AccountService {

	@Inject
	private iAccountRepository accRepo;

	@Inject
	private iAccountValidator validator;

	public String addAccount(String account) {
		String returnMsg;
		if(validator.isValid(account)) {
			returnMsg = accRepo.createAnAccount(account);
		}else {
			returnMsg = "{\"message\": \"account blocked\"}";	
		}
		return returnMsg;
	}

	public Account getAccount(long accNo) {
		return accRepo.findAnAccount(accNo);
	}

	public String deleteAccount(long accNo) {
		return accRepo.deleteAccount(accNo);
	}

	public String updateAccount(long accNo, String newAcount) {
		return accRepo.updateAnAccount(newAcount, accNo);
	}

	public String getAllAccounts() {
		return accRepo.getAllAccounts();
	}
}
