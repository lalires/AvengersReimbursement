package com.revature.bean;

import java.sql.Blob;
import java.sql.Date;


public class Reimbursement {
	
	double Amount;
	String Description;
	Blob reciept;
	String resolved;
	int author;
	int resolver;
	int rtype;
	int rstatus;
	

	public Reimbursement(double amount, String description, String resolved, int author, int resolver,
			int rtype, int rstatus) {
		super();
		Amount = amount;
		Description = description;
		this.resolved = resolved;
		this.author = author;
		this.resolver = resolver;
		this.rtype = rtype;
		this.rstatus = rstatus;
	}


	public double getAmount() {
		return Amount;
	}


	public void setAmount(double amount) {
		Amount = amount;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public Blob getReciept() {
		return reciept;
	}


	public void setReciept(Blob reciept) {
		this.reciept = reciept;
	}


	public Reimbursement(double amount, String description, int author, int rtype) {
		super();
		Amount = amount;
		Description = description;
		this.author = author;
		this.rtype = rtype;
	}


	public String getResolved() {
		return resolved;
	}


	public void setResolved(String resolved) {
		this.resolved = resolved;
	}


	public int getAuthor() {
		return author;
	}


	public void setAuthor(int author) {
		this.author = author;
	}


	public int getResolver() {
		return resolver;
	}


	public void setResolver(int resolver) {
		this.resolver = resolver;
	}


	public int getRtype() {
		return rtype;
	}


	public void setRtype(int rtype) {
		this.rtype = rtype;
	}


	public int getRstatus() {
		return rstatus;
	}


	public void setRstatus(int rstatus) {
		this.rstatus = rstatus;
	}
	
	
	
	

}
