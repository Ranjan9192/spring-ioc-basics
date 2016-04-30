package com.mahendra.springbasics.models;

public class Book extends Model {
	
	private String title, author, description;
	
	public Book(Short bookId, String title, String author, String description) {
		super();
		this.id = bookId;
		this.title = title;
		this.author = author;
		this.description = description;
	}
	public Short getBookId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
