package com.BookApp.Registration.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.BookApp.Registration.model.User;



public interface Registrationdao extends MongoRepository<User, String>  {

	public User findByEmailId(String emailId);
	public User findByEmailIdAndPassword(String emailId,String password);

}
