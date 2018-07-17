package com.qa.persistence.repository;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.util.JSONUtility;

@RunWith(MockitoJUnitRunner.class)
public class AccountDBRepositoryTest {
	
	@InjectMocks
	private AccountDBRepository repo;

	@Mock
	private EntityManager em;
	
	@Mock
	private JSONUtility util;

	@Test
	public void createAccount() {
		repo.setEm(em);
		repo.setUtil(util);
		assertEquals("{\"message\": \"account sucessfully added\"}",repo.createAnAccount("\"{\\\"\" +\"firstName\\\"\" + \":\" + \"\\\"abc\\\"\" +\",\" + \"\\\"surname\\\"\" + \":\" + \"\\\"xyz\\\"\" + \",\" + \"\\\"accNo\\\"\" + \":1\" + \"}\""));
	}
	
	@Test
	public void deleteAccount() {
		repo.setEm(em);
		assertEquals("{\"message\": \"account sucessfully deleted\"}",repo.deleteAccount(1));
	}
	
	@Test
	public void updateAccount() {
		repo.setEm(em);
		repo.setUtil(util);
		assertEquals("{\"message\": \"account sucessfully updated\"}",repo.updateAnAccount("\"{\\\"\" +\"firstName\\\"\" + \":\" + \"\\\"abc\\\"\" +\",\" + \"\\\"surname\\\"\" + \":\" + \"\\\"xyz\\\"\" + \",\" + \"\\\"accNo\\\"\" + \":1\" + \"}\"",1));
	}
	
	
}
