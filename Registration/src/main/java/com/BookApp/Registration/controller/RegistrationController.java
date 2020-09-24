package com.BookApp.Registration.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.BookApp.Registration.Exception.LoginException;
import com.BookApp.Registration.Exception.RegistrationException;
import com.BookApp.Registration.model.User;
import com.BookApp.Registration.service.RegistrationService;




@CrossOrigin
@RestController

public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping(value = "/registeruser")
	public User  registeruser(@RequestBody User user)   {
		String tempEmailId = user.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			User userobj =registrationService.fetchUserByEmailId(tempEmailId);
			if(userobj != null) { 
				throw new RegistrationException("User with this Email already exists");
			
			}
		}
		
		return registrationService.saveUser(user);
	}
	@PutMapping(value = "/modifyuser")
	public User  modifyuser(@RequestBody User user)   {
		String tempEmailId = user.getEmailId();
		User userobj =registrationService.fetchUserByEmailId(tempEmailId);	
		user.setId(userobj.getId());
		userobj=registrationService.saveUser(user);
		return userobj ;
	}
	
	
	@PostMapping(value="/getuser")
	public User getuser(@RequestBody String email)
	{
		String tempEmailId = email;
		return registrationService.fetchUserByEmailId(tempEmailId);
	}
	
	
	
	
	
	@DeleteMapping(value = "/delete/{user-emailId}")
	public String delete(@PathVariable(value = "user-id") String email) {
		registrationService.deleteUserByEmailId(email);
		return "User record deleted.";
	}
	
	
	  @PostMapping(value = "/login")
	  public User loginUser(@RequestBody User user) { 
	  String tempEmailId = user.getEmailId(); 
	  String tempPass = user.getPassword(); 
	  User userobj = null; 
	  if(tempEmailId != null && tempPass!= null) {
	  userobj=registrationService.fetchUserByEmailIdAndPassword(tempEmailId,tempPass); 
	  } 
	  if(userobj == null) 
	  { 
		  throw new LoginException("BadCredential/UserDosenot Exist");
		  //throw new Exception("BadCredential/UserDosenot Exist"); 
	  } 
	  return userobj; 
 }
	 
}
