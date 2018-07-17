package com.qa.service.business;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.iAccountRepository;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

	@InjectMocks
	private AccountService accServ;

	@Mock
	private iAccountRepository accRepo;

	@Mock
	private iAccountValidator validator;

	@Test
	public void addAccountTest() {
		accServ.setAccRepo(accRepo);
		accServ.setValidator(validator);
		Mockito.when(validator.isValid("1234")).thenReturn(true);

		Mockito.when(accRepo.createAnAccount("1234")).thenReturn("created");
		assertEquals("created", accServ.addAccount("1234"));
		Mockito.verify(accRepo).createAnAccount("1234");

	}

	@Test
	public void addAccountTestInvalid() {
		accServ.setAccRepo(accRepo);
		accServ.setValidator(validator);
		Mockito.when(validator.isValid("9999")).thenReturn(false);
		Mockito.when(accRepo.createAnAccount("9999")).thenReturn("\\\"message\\\": \\\"account blocked\\\"}");
		assertEquals("{\"message\": \"account blocked\"}", accServ.addAccount("9999"));
	}
	
	@Test
	public void getAccount() {
		accServ.setAccRepo(accRepo);
		Account account = new Account();
		Mockito.when(accRepo.findAnAccount(1)).thenReturn(account);
		assertEquals(account,accServ.getAccount(1));
		Mockito.verify(accRepo).findAnAccount(1);
	}
	
	@Test
	public void getAllAccount() {
		accServ.setAccRepo(accRepo);
		Mockito.when(accRepo.getAllAccounts()).thenReturn("test output");
		assertEquals("test output" ,accServ.getAllAccounts());
		Mockito.verify(accRepo).getAllAccounts();
	}
	
	@Test
	public void updateAccountTest() {
		accServ.setAccRepo(accRepo);
		accServ.setValidator(validator);
		Mockito.when(validator.isValid("1234")).thenReturn(true);
		Mockito.when(accRepo.updateAnAccount("1234",1)).thenReturn("created");
		assertEquals("created", accServ.updateAccount(1, "1234"));
		Mockito.verify(accRepo).updateAnAccount("1234",1);
	}
	
	@Test
	public void updateAccountTestInvalid() {
		accServ.setAccRepo(accRepo);
		accServ.setValidator(validator);
		Mockito.when(validator.isValid("9999")).thenReturn(false);
		Mockito.when(accRepo.updateAnAccount("9999",1)).thenReturn("\\\"message\\\": \\\"account blocked\\\"}");
		assertEquals("{\"message\": \"account blocked\"}", accServ.updateAccount(1, "9999"));
	}
	
	@Test
	public void deleteAccountTest() {
		accServ.setAccRepo(accRepo);
		Mockito.when(accRepo.deleteAccount(1)).thenReturn("deleted");
		assertEquals("deleted", accServ.deleteAccount(1));
		Mockito.verify(accRepo).deleteAccount(1);
	}
}
