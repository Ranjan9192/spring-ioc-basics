package com.mahendra.iocdemo1.app;

import com.mahendra.iocdemo1.dao.BookDAO;
import com.mahendra.iocdemo1.service.BookService;
import com.mahendra.iocdemo1.service.IssueService;

public class MainApp {

	public static void main(String[] args) {
		//Create Dependecies FIRST
		BookDAO dao = new BookDAO();
		
		
		BookService service1 = new BookService(dao);
		BookService service2 = new BookService(dao);
		IssueService service3 = new IssueService(dao);
		
		System.out.println("In Main...");

	}

}
