package com.qa.service.business;

import javax.enterprise.inject.Default;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Account;
import com.qa.persistence.util.JSONUtility;

@Default
public class AccNoValidator implements iAccountValidator {
	
	private static final Logger LOGGER = Logger.getLogger(AccNoValidator.class);

	@Inject
	private JSONUtility jUtil;

	public AccNoValidator() {

	}

	public boolean isValid(String account) {
		LOGGER.info("account validato is valid");
		return !jUtil.getObjectForJSON(account, Account.class).getAccNo().equals("9999");
	}

	public JSONUtility getjUtil() {
		return jUtil;
	}

	public void setjUtil(JSONUtility jUtil) {
		this.jUtil = jUtil;
	}
}
