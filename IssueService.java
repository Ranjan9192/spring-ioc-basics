package com.mahendra.iocdemo1.service;

import com.mahendra.iocdemo1.dao.BookDAO;

public class IssueService {
	private BookDAO dao;

	public IssueService() {
		super();
		dao = new BookDAO();
		System.out.println("New instance created for IssueService");
	}
	
	public IssueService(BookDAO dao){
		this.dao = dao;
	}
	
}
