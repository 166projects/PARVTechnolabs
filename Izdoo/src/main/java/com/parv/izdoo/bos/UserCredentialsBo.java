package com.parv.izdoo.bos;

import com.parv.izdoo.entities.UserCredentials;

public interface UserCredentialsBo {

	public UserCredentials login(String userId, String password) throws Exception;
	public void changePassword(String userId, String password);
	public UserCredentials getUserCredentialsById(String userId);
	public void updateUserCredentials(UserCredentials userCredentials);
}
