package com.mahendra.springbasics.models;

import java.io.Serializable;
import java.util.Date;

public class Issue extends Model {
	
	private Date issueDate;
	private Member issuedTo;
	private Book book;
	private boolean pending;
	public Short getIssueId() {
		return id;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Member getIssuedTo() {
		return issuedTo;
	}
	public void setIssuedTo(Member issuedTo) {
		this.issuedTo = issuedTo;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public boolean isPending() {
		return pending;
	}
	public void setPending(boolean pending) {
		this.pending = pending;
	}
	public Issue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Issue(Short issueId, Member issuedTo, Book book) {
		super();
		this.id = issueId;
		this.issueDate = new Date();
		this.issuedTo = issuedTo;
		this.book = book;
		this.pending = true;
	}
	
}
