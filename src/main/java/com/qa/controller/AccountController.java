package com.qa.controller;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Account;
import com.qa.service.business.iAccountService;

@Path("/account")
public class AccountController {

	@Inject
	private iAccountService accServ;
	
	private static final Logger LOGGER = Logger.getLogger(AccountController.class);

	public AccountController() {

	}

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		LOGGER.info("account controller get all accounts");
		return accServ.getAllAccounts();
	}

	@Path("/json/{id}")
	@GET
	@Produces({ "application/json" })
	public Account findAccount(@PathParam("id") Long id) {
		LOGGER.info("account controller find account");
		return accServ.getAccount(id);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Long id, String account) {
		LOGGER.info("account controller update account");
		return accServ.updateAccount(id, account);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) {
		LOGGER.info("account controller delete account");
		return accServ.deleteAccount(id);
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createAccount(String account) {
		LOGGER.info("account controller create new account");
		return accServ.addAccount(account);
	}

	public iAccountService getAccServ() {
		return accServ;
	}

	public void setAccServ(iAccountService accServ) {
		this.accServ = accServ;
	}

}
