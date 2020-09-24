package com.BookApp.Registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookApp.Registration.dao.Registrationdao;
import com.BookApp.Registration.model.User;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	Registrationdao registrationDao;

	@Override
	public User saveUser(User user) {
		
		return registrationDao.save(user);
	}

	@Override
	public User fetchUserByEmailId(String email) {
		return registrationDao.findByEmailId(email);
		
	}

	
	  @Override public User fetchUserByEmailIdAndPassword(String email, String password) {
	  
	  return registrationDao.findByEmailIdAndPassword(email, password);
			  
	  }
	  
	  @Override
		public void deleteUserByEmailId(String emailId) {
			registrationDao.deleteById(emailId);
		}


	  
	 
	  

	 

}
