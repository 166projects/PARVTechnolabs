package com.parv.izdoo.bos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parv.izdoo.daos.UserCredentialsDao;
import com.parv.izdoo.entities.UserCredentials;

@Service
public class UserCredentialsBoImpl implements UserCredentialsBo {

	@Autowired
	UserCredentialsDao userCredentialsDao;
	
	public UserCredentials login(String EMPLOYER_ID, String password) throws Exception {
		
		UserCredentials userCredentials = null;
		
		if(EMPLOYER_ID.matches("[A-Z0-9/-]{6}") && password.matches("[A-Za-z0-9]{8,}")) {
			 System.out.println("arpit");
			userCredentials = userCredentialsDao.login(EMPLOYER_ID, password);
			
		}
		else {
			throw new Exception("Invalid userId or password");
		}
		System.out.println(userCredentials);
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
