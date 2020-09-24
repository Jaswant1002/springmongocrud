package com.BookApp.Registration.service;

import com.BookApp.Registration.model.User;

public interface RegistrationService {

	User saveUser(User user);
	User fetchUserByEmailId(String email);
	User fetchUserByEmailIdAndPassword(String email, String password);
	void deleteUserByEmailId(String emailId);

}
