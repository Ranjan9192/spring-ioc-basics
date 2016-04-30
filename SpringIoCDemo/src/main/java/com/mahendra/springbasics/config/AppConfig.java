package com.mahendra.springbasics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mahendra.springbasics.dao.BookRepository;
import com.mahendra.springbasics.dao.IssueRepository;
import com.mahendra.springbasics.dao.MemberRepository;
import com.mahendra.springbasics.service.LibraryServiceWithDI;


@Configuration
//@ComponentScan(basePackages={"com.mahendra.springbasics"})
public class AppConfig {
	
	@Bean 
	public BookRepository br(){
		return new BookRepository();
	}
	
	@Bean 
	public IssueRepository ir(){
		return new IssueRepository();
	}
	
	@Bean
	public MemberRepository mr (){
		return new MemberRepository();
	}
	
	@Bean public LibraryServiceWithDI service(){
		return new LibraryServiceWithDI(br(), ir(), mr());
	}
}
