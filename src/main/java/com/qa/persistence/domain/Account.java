package com.qa.persistence.domain;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 50)
	private String firstName;
	@Column(length = 50)
	private String surname;
	@Column(length = 4)
	private String accNo;

	@OneToMany(mappedBy = "account_id", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Transaction> transactions;

	public Account() {
	}

	public Account(String firstName, String surname, String accNo) {
		this.firstName = firstName;
		this.surname = surname;
		this.accNo = accNo;
		this.transactions = new ArrayList<Transaction>();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

}
