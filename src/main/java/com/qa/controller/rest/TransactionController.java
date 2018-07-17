package com.qa.controller.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Transaction;
import com.qa.service.business.iTransactionService;

@Path("/transaction")
public class TransactionController {

	private static final Logger LOGGER = Logger.getLogger(TransactionController.class);

	@Inject
	private iTransactionService tServ;

	public TransactionController() {

	}

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllTransactions() {
		LOGGER.info(" transaction controller get all transactions");
		return tServ.getAllTransactions();
	}

	@Path("/json/{id}")
	@GET
	@Produces({ "application/json" })
	public Transaction findTransaction(@PathParam("id") Long id) {
		LOGGER.info(" transaction controllerfind transaction");
		return tServ.findTransaction(id);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateTransaction(@PathParam("id") Long id, String newTransaction) {
		LOGGER.info(" transaction controller update transations");
		return tServ.updateTransaction(newTransaction, id);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTransaction(@PathParam("id") Long id) {
		LOGGER.info(" transaction controller delete transaction");
		return tServ.deleteTransaction(id);
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createTransaction(String transaction) {
		LOGGER.info(" transaction controllercreate transaction");
		return tServ.addTransaction(transaction);
	}
}
