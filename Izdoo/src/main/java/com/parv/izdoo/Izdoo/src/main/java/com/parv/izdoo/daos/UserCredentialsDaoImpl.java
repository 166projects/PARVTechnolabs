package com.parv.izdoo.daos;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

	public UserCredentials login(String EMPLOYER_ID, String password) throws Exception {
		
		 
		
		Session session = sessionFactory.openSession();
		//UserCredentials userCredentials = (UserCredentials) session.get(UserCredentials.class, userId);
		System.out.println("session open");
		//Query q=session.createQuery("from UserCredentials where EMPLOYER_ID =: userId");
		TypedQuery q = session.createQuery("from UserCredentials where EMPLOYER_ID =: EMPLOYER_ID");
		q.setParameter("EMPLOYER_ID", EMPLOYER_ID);
		System.out.println("query run");
		UserCredentials userCredentials = (UserCredentials) q.getSingleResult();
        try {
        	System.out.println(userCredentials.getPassword()
        			+"\t"+password);
              if(userCredentials.getPassword().equals(password)) {
            	  
		    	return userCredentials;
             
              }
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
		Transaction tr = session.beginTransaction();
		session.update(userCredentials);
		tr.commit();
		session.close();
	}

	public UserCredentials getUserCredentialsById(String EMPLOYER_ID) {
		
		Session session = sessionFactory.openSession();
		
	
		Query q=session.createQuery("from UserCredentials where EMPLOYER_ID =: EMPLOYER_ID");
		q.setParameter("EMPLOYER_ID", EMPLOYER_ID);
		UserCredentials userCredentials = (UserCredentials) q.uniqueResult();	
		return userCredentials;	
	}

	public void updateUserCredentials(UserCredentials userCredentials) {
		
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(userCredentials);
		tr.commit();
		
		session.close();
	}
}
