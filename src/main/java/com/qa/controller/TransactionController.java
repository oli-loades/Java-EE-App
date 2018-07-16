package com.qa.controller;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.persistence.domain.Transaction;
import com.qa.service.business.TransactionService;

@Path("/transaction")
public class TransactionController {
	@Inject
	private TransactionService tServ;
	
	public TransactionController() {
		
	}
	
	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllTransactions() {
		return tServ.getAllTransactions();
	}
	
	@Path("/json/{id}")
	@GET
	@Produces({ "application/json" })
	public Transaction findTransaction(@PathParam("id") Long id) {
		return tServ.findTransaction(id);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateTransaction(@PathParam("id") Long id, String newTransaction) {
		return tServ.updateTransaction(newTransaction, id);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTransaction(@PathParam("id") Long id) {
		return tServ.deleteTransaction(id);
	}
	
	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createTransaction(String transaction) {
		return tServ.addTransaction(transaction);
	}
}
