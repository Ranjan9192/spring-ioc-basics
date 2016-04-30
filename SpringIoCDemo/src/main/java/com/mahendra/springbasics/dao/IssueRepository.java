package com.mahendra.springbasics.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

import com.mahendra.springbasics.models.*;

//@Repository
public class IssueRepository {
	private SortedSet<Issue> issues = new TreeSet<Issue>();
	
	public Issue add(Book book, Member member){
		short issueId = (short) (issues.size()+1);
		Issue issue = new Issue(issueId, member,book);
		issues.add(issue);
		return issue;
	}
	
	public Issue findById(short id){
		for(Issue b : issues){
			if(b.getIssueId() == id){
				return b;
			}
		}
		return null;
	}
	public boolean isBookAvailable(short bookId){
		for(Issue i : issues){
			if(i.getBook().getBookId() == bookId && !i.isPending()){
				return false;
			}
		}
		return true;
	}
	
	public boolean isMemberAvailable(short memberId){
		for(Issue i : issues){
			if(i.getIssuedTo().getMemberId()== memberId && !i.isPending()){
				return false;
			}
		}
		return true;
	}
	
	public List<Issue> getAllPending(){
		List<Issue> temp = new LinkedList<Issue>();
		for(Issue i : issues){
			if(i.isPending())
				temp.add(i);
		}
		return temp;
	}
	
	public List<Issue> getAllReturned(){
		List<Issue> temp = new LinkedList<Issue>();
		for(Issue i : issues){
			if(!i.isPending())
				temp.add(i);
		}
		return temp;
	}
	
	public List<Issue> getAll(){
		List<Issue> temp = new LinkedList<Issue>();
		temp.addAll(issues);
		return temp;
	}
}
