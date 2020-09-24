package com.BookApp.Registration.model;

import javax.annotation.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "user")
public class User {
	
	//@Id
	//for auto id generate
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	

	//@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
//	@SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "user_seq")
	@Id
	private String id;
	private String emailId;
	private String userName;
	private String password;
	
	public User(String id, String emailId, String userName, String password) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
