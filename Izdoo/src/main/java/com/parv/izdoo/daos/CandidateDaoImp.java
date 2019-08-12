package com.parv.izdoo.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.parv.izdoo.entities.Candidate;

@Repository
@Transactional
public class CandidateDaoImp implements CandidateDao{
    
	 @Autowired
	 SessionFactory sessionFactory;
	 
//	 Session session=sessionFactory.openSession();;
	
	 
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
		Session session=sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		session.update(candidate);
		tr.commit();
		//session.close();
	}

	public void signupCandidate(Candidate candidate) {
	
		Session session=sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(candidate);
		tr.commit(); 
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

	public List<Candidate> getAllEligibleCandidates() {
		Session session = sessionFactory.openSession();
		List<Candidate> candidates= session.createQuery("from Candidate where eligibility = 'eligible'").list();
		
		return candidates;
	}

	public Candidate getById(String candidateId) {
		Session session = sessionFactory.getCurrentSession();
		Candidate candidate = (Candidate) session.get(Candidate.class, candidateId);
		return candidate;
	}
		
		
		
		
		
	}


