package com.parv.izdoo.bos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parv.izdoo.daos.UserCredentialsDao;
import com.parv.izdoo.entities.UserCredentials;

@Service
public class UserCredentialsBoImpl implements UserCredentialsBo {

	@Autowired
	UserCredentialsDao userCredentialsDao;
	
	public UserCredentials login(String userId, String password) throws Exception {
		
		UserCredentials userCredentials = null;
		
		if(userId.matches("[A-Z0-9/-]{6}") && password.matches("[A-Za-z0-9]{8,}")) {
			 
			userCredentials = userCredentialsDao.login(userId, password);
		}
		else {
			throw new Exception("Invalid userId or password");
		}
			
		return userCredentials;
	}

	public void changePassword(String userId, String password) {
		
		userCredentialsDao.changePassword(userId, password);
	}

	public UserCredentials getUserCredentialsById(String userId) {
		
		return userCredentialsDao.getUserCredentialsById(userId);
	}

	public void updateUserCredentials(UserCredentials userCredentials) {
		
		userCredentialsDao.updateUserCredentials(userCredentials);
	}

}
