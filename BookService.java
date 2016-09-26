package com.mahendra.iocdemo1.service;

import com.mahendra.iocdemo1.dao.BookDAO;

public class BookService {
	
	private BookDAO dao;
	
	//Without IoC / DI 
	public BookService(){
		dao = new BookDAO();
		System.out.println("New instance of BookService created!");
	}
	
	//With DI (Constructor Injection
	public BookService(BookDAO dao){
		this.dao = dao;
	}
	
	
}
