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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "account")
@XmlAccessorType(value = XmlAccessType.FIELD)
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Size(min = 1, max =50)
	@NotNull
	private String firstName;
	
	
	@Column(length = 50)
	@Size(min = 1, max =50)
	@NotNull
	private String surname;
	
	
	@Column
	@Size(min = 4, max =4)
	@NotNull
	private String accNo;

	@XmlTransient
	@Size(max = 100)
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

	//@XmlElement (name = "firstname")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	//@XmlElement (name = "surname")
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	//@XmlElement (name = "accno")
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
