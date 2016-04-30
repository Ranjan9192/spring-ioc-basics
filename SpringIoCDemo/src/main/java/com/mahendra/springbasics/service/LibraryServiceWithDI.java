package com.mahendra.springbasics.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.mahendra.springbasics.dao.*;
import com.mahendra.springbasics.models.Book;
import com.mahendra.springbasics.models.Member;

//@Service
//@Scope(value="prototype")
public class LibraryServiceWithDI {

	private BookRepository bookRepo;
	private IssueRepository issueRepo;
	private MemberRepository memberRepo;
	
	private static Logger log = Logger.getLogger(LibraryServiceWithDI.class.getCanonicalName());
	
	//IoC : Do Not allow object to create dependencies
	//Create dependencies somewhere else, and
	//Provide reference to dependencies using
	//Either Constructor [Constructor Injection]
	//Or Setters [Property / Setter Injection]
	
	@Autowired
	public LibraryServiceWithDI(BookRepository bookRepo,
			IssueRepository issueRepo, MemberRepository memberRepo) {
		super();
		
		log.info("Constructing instance !");
		this.bookRepo = bookRepo;
		this.issueRepo = issueRepo;
		this.memberRepo = memberRepo;
	}

	public void saveBook(Book book){
		bookRepo.add(book.getTitle(), book.getAuthor(), book.getDescription());
	}
	
	public void saveMember(Member member){
		memberRepo.add(member.getFirstName(), member.getLastName(), member.getContact());
	}
	
	public boolean issueBook(short bookId, short memberId){
		Book book = bookRepo.findById(bookId);
		Member member = memberRepo.findById(memberId);
		if(book == null || member == null){
			return false;
		}
		if(issueRepo.isBookAvailable(bookId) && issueRepo.isMemberAvailable(memberId)){
			issueRepo.add(book, member);
		}
		return true;
	}
	
}
