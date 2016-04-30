package com.mahendra.springbasics.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.mahendra.springbasics.models.Book;
import com.mahendra.springbasics.models.Issue;

//@Repository
//@Primary //Spring 4.x Force spring to use THIS instance
		//when Multiple instances are available for injection
public class BookRepository {
	private SortedSet<Book> books = new TreeSet<Book>();
	
	public Book add(String title, String author, String description){
		short bookId = (short) (books.size()+1);
		Book book = new Book(bookId,title, author, description);
		books.add(book);
		return book;
	}
	
	public Book findById(short id){
		for(Book b : books){
			if(b.getBookId() == id){
				return b;
			}
		}
		return null;
	}
	
	public Set<Book> searchByTitle(String title){
		Set<Book> temp = new TreeSet<Book>();
		for(Book b : books){
			if(b.getTitle().toLowerCase().contains(title)){
				temp.add(b);
			}
		}
		return temp;
	}
	
	public Set<Book> searchByDescription(String description){
		Set<Book> temp = new TreeSet<Book>();
		for(Book b : books){
			if(b.getDescription().toLowerCase().contains(description)){
				temp.add(b);
			}
		}
		return temp;
	}
	
	public Set<Book> searchByAuthor(String author){
		Set<Book> temp = new TreeSet<Book>();
		for(Book b : books){
			if(b.getAuthor().toLowerCase().contains(author)){
				temp.add(b);
			}
		}
		return temp;
	}
	
	public List<Book> getAll(){
		List<Book> temp = new LinkedList<Book>();
		temp.addAll(books);
		return temp;
	}
}
