package com.qa.controller;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.controller.AccountController;
import com.qa.persistence.domain.Account;
import com.qa.service.business.iAccountService;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

	@InjectMocks
	private AccountController controller;

	@Mock
	private iAccountService accServ;

	@Test
	public void addAccountTest() {
		controller.setAccServ(accServ);
		Mockito.when(accServ.addAccount("test account")).thenReturn("expected string");
		assertEquals("expected string",controller.createAccount("test account"));
		Mockito.verify(accServ).addAccount("test account");
	}
	
	@Test
	public void deleteAccountTest() {
		controller.setAccServ(accServ);
		Mockito.when(accServ.deleteAccount(1)).thenReturn("deleted");
		assertEquals("deleted",controller.deleteAccount((long) 1));
		Mockito.verify(accServ).deleteAccount(1);
	}
	
	@Test
	public void updateAccountTest() {
		controller.setAccServ(accServ);
		Mockito.when(accServ.updateAccount(1,"account")).thenReturn("updated");
		assertEquals("updated",controller.updateAccount((long) 1,"account"));
		Mockito.verify(accServ).updateAccount(1,"account");
	}
	
	@Test
	public void findAccountTest() {
		controller.setAccServ(accServ);
		Account account = new Account();
		Mockito.when(accServ.getAccount(1)).thenReturn(account);
		assertEquals(account,controller.findAccount((long) 1));
		Mockito.verify(accServ).getAccount(1);
	}

}
