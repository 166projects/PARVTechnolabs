package com.parv.izdoo.daos;

import com.parv.izdoo.entities.UserCredentials;

public interface UserCredentialsDao {
	
	public UserCredentials login(String userId, String password) throws Exception;
	public void changePassword(String userId, String password);
	public UserCredentials getUserCredentialsById(String userId);
	public void updateUserCredentials(UserCredentials userCredentials);

}
