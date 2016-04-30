package com.mahendra.springbasics.service;

import com.mahendra.springbasics.dao.*;
import com.mahendra.springbasics.models.Book;
import com.mahendra.springbasics.models.Member;

public class LibraryService {

	private BookRepository bookRepo;
	private IssueRepository issueRepo;
	private MemberRepository memberRepo;
	
	public LibraryService() {
		super();
		bookRepo = new BookRepository();
		issueRepo = new IssueRepository();
		memberRepo = new MemberRepository();
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
