package com.mahendra.springbasics.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

import com.mahendra.springbasics.models.Member;

//@Repository
public class MemberRepository {
	private SortedSet<Member> members = new TreeSet<Member>();
	
	public Member add(String firstName, String lastName, String contact){
		short memberId = (short) (members.size()+1);
		Member member = new Member(memberId,firstName,lastName,contact);
		members.add(member);
		return member;
	}
	
	public Member findById(short id){
		for(Member b : members){
			if(b.getMemberId() == id){
				return b;
			}
		}
		return null;
	}
	
	public Set<Member> searchByFirstName(String firstName){
		Set<Member> temp = new TreeSet<Member>();
		for(Member b : members){
			if(b.getFirstName().equalsIgnoreCase(firstName.trim())){
				temp.add(b);
			}
		}
		return temp;
	}
	
	public Set<Member> searchByLastName(String lastName){
		Set<Member> temp = new TreeSet<Member>();
		for(Member b : members){
			if(b.getFirstName().equalsIgnoreCase(lastName.trim())){
				temp.add(b);
			}
		}
		return temp;
	}
	
	public List<Member> getAll(){
		List<Member> temp = new LinkedList<Member>();
		temp.addAll(members);
		return temp;
	}
}
