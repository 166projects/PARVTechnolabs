package com.parv.izdoo.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.parv.izdoo.entities.Candidate;
@Repository
@Transactional
public class CandidateDaoImp implements CandidateDao{
    
	 @Autowired
	 SessionFactory sessionFactory;
	 
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Candidate> getAllCandidates() {
		Session session=sessionFactory.openSession();
		List<Candidate> candidates=session.createCriteria(Candidate.class).list();
		session.close();
		return candidates;
	}

	public void updateCandidate(Candidate candidate) {
		Session session=sessionFactory.openSession();
	
		session.update(candidate);
		session.close();
	}

	public void signupCandidate(Candidate candidate) {
	
		Session session=sessionFactory.openSession();
		
		session.save(candidate);
		session.close();
		
	}

	public Candidate login(String email, String password) throws Exception{
		Candidate candidates=null;
		Session session=sessionFactory.openSession();
	
		Query query=session.createQuery("from Candidate where email=:email and pass=:pass");
        query.setString("email",email);
        query.setString("pass", password);
        try {
        candidates=(Candidate)query.uniqueResult();
    	
        }catch(Exception e)
        {
      	  throw new Exception("invalid Credentials");
        }
    	session.close();
        return candidates;
 }

	@Override
	public List<Candidate> getAllEligibleCandidates() {
		Session session = sessionFactory.openSession();
		List<Candidate> candidates= session.createQuery("from Candidate where eligibility = 'eligible'").list();
		
		return candidates;
	}
		
		
		
		
		
	}


