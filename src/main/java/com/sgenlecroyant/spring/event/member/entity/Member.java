package com.sgenlecroyant.spring.event.member.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "members")
@Table(name = "members")
public class Member {
	
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	
	public Member(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
