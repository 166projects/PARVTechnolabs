package com.parv.izdoo.daos;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.parv.izdoo.entities.UserCredentials;

@Repository
@Transactional
public class UserCredentialsDaoImpl implements UserCredentialsDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserCredentials login(String userId, String password) throws Exception {
		
		UserCredentials userCredentials = null;
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from userCredentials where userId=:userId and password=:password");
		query.setString("userId", userId);
		query.setString("password", password);
		try {
			userCredentials = (UserCredentials) query.uniqueResult();
			session.close();
		}
		catch(Exception e) {
			throw new Exception("Invalid Employee");
		}
		return userCredentials;
	}

	public void changePassword(String userId, String password) {
		
		Session session = sessionFactory.openSession();
		
		UserCredentials userCredentials = (UserCredentials) session.get(UserCredentials.class, userId);
		userCredentials.setPassword(password);
		
		session.update(userCredentials);
		
		session.close();
	}

	public UserCredentials getUserCredentialsById(String userId) {
		
		Session session = sessionFactory.openSession();
		
		UserCredentials userCredentials = (UserCredentials) session.get(UserCredentials.class, userId);
		session.save(userCredentials);
		
		session.close();
		
		return userCredentials;	
	}

	public void updateUserCredentials(UserCredentials userCredentials) {
		
		Session session = sessionFactory.openSession();
		
		session.update(userCredentials);
		
		session.close();
	}
}
