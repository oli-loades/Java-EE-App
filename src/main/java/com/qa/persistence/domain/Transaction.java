package com.qa.persistence.domain;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String name;

	@Column
	private long account_id;

	public Transaction() {
	}

	public Transaction(String name, long account_id) {
		this.name = name;
		this.account_id = account_id;
	}

	public long getAccountId() {
		return account_id;
	}

	public void setAccountId(long account_id) {
		this.account_id = account_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

}
