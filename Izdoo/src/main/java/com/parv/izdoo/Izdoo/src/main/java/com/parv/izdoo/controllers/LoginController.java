package com.parv.izdoo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parv.izdoo.bos.UserCredentialsBo;
import com.parv.izdoo.entities.UserCredentials;

@RestController
@RequestMapping("/employer-login")
public class LoginController {

	@Autowired
	UserCredentialsBo userCredentialsBo;

	@RequestMapping(value = "/login/{EMPLOYER_ID}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserCredentials login(@PathVariable("EMPLOYER_ID") String EMPLOYER_ID, @PathVariable("password") String password) {

		
			UserCredentials userCredentials=null;
			try {
				userCredentials = userCredentialsBo.login(EMPLOYER_ID, password);
				userCredentials.setLoginStatus("LOGGED IN");
				userCredentialsBo.updateUserCredentials(userCredentials);
				System.out.println(userCredentials);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userCredentials;
		
	}
	
	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserCredentials getById(@PathVariable("id") String id) {
		UserCredentials userCredentials = userCredentialsBo.getUserCredentialsById(id);
		return userCredentials;
	}
}
