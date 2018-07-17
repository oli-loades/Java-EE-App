package com.qa.controller.soap;

import java.io.StringReader;

import javax.inject.Inject;
import javax.jws.WebService;
import javax.xml.bind.JAXB;

import com.qa.persistence.domain.Account;
import com.qa.persistence.util.JSONUtility;
import com.qa.service.business.iAccountService;

@WebService(endpointInterface = "com.qa.controller.soap.AccountSOAPInterface")
public class AccountSOAPEndpoint implements AccountSOAPInterface {
	
	@Inject
	private JSONUtility util;
	
	@Inject
	private iAccountService accServ;

	public String addAccount(String account) {
		return accServ.addAccount(util.getJSONForObject(JAXB.unmarshal(new StringReader(account), Account.class)));
	}

	public Account getAccount(long id) {
		return  accServ.getAccount(id);
	}

	public String deleteAccount(long id) {
		return accServ.deleteAccount(id);
	}

	public String updateAccount(long id, String account) {
		return accServ.updateAccount(id, util.getJSONForObject(JAXB.unmarshal(new StringReader(account), Account.class)));
	}

	public String getAllAccounts() {
		return accServ.getAllAccounts();
	}
	
	

}
