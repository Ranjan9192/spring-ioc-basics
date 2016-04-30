package com.mahendra.springbasics.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.mahendra.springbasics.config.AppConfig;
import com.mahendra.springbasics.service.LibraryServiceWithDI;

public class MainWithDI {

	public static void main(String[] args) {
		/*BookRepository br = new BookRepository();
		MemberRepository mr = new MemberRepository();
		IssueRepository ir = new IssueRepository();
		
		LibraryServiceWithDI service = 
					new LibraryServiceWithDI(br, ir, mr);*/
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("mahendra.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		LibraryServiceWithDI service1 = context.getBean(LibraryServiceWithDI.class);
		System.out.println("First call to get instance :"+service1);
		
		LibraryServiceWithDI service2 = context.getBean(LibraryServiceWithDI.class);
		System.out.println("Second call to get instance : "+service2);
	}

}
