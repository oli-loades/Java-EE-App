package com.qa.service.business;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.util.JSONUtility;

@Default
public class AccNoValidator implements iAccountValidator{
	
	@Inject
	private JSONUtility jUtil;
	
	public AccNoValidator() {
		
	}
	
	public boolean isValid(String account) {
		return !jUtil.getObjectForJSON(account, Account.class).getAccNo().equals("9999");
	}
}
