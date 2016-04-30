package com.mahendra.springbasics.models;

public class Member extends Model {
private String firstName, lastName, contact;
public Short getMemberId() {
	return id;
}


public Member(Short memberId, String firstName, String lastName, String contact) {
	super();
	this.id = memberId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.contact = contact;
}

public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}

}
