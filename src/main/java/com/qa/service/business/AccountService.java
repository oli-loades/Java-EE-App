package com.qa.service.business;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.iAccountRepository;

public class AccountService implements iAccountService {
	
	private static final Logger LOGGER = Logger.getLogger(AccountService.class);

	@Inject
	private iAccountRepository accRepo;

	@Inject
	private iAccountValidator validator;

	public AccountService() {
	}

	public String addAccount(String account) {
		LOGGER.info("account service create account");
		String returnMsg;
		if (validator.isValid(account)) {
			returnMsg = accRepo.createAnAccount(account);
		} else {
			returnMsg = "{\"message\": \"account blocked\"}";
		}
		return returnMsg;
	}

	public Account getAccount(long id) {
		LOGGER.info("account service get account");
		return accRepo.findAnAccount(id);
	}

	public String deleteAccount(long id) {
		LOGGER.info("account service delete account");
		return accRepo.deleteAccount(id);
	}

	public String updateAccount(long id, String newAcount) {
		LOGGER.info("account service update account");
		String returnMsg;
		if (validator.isValid(newAcount)) {
			returnMsg = accRepo.updateAnAccount(newAcount, id);
		} else {
			returnMsg = "{\"message\": \"account blocked\"}";
		}
		return returnMsg;
	}

	public String getAllAccounts() {
		LOGGER.info("account service get all accounts");
		return accRepo.getAllAccounts();
	}

}
