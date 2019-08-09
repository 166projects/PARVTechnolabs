package com.parv.izdoo.bos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parv.izdoo.daos.CandidateDao;
import com.parv.izdoo.entities.Candidate;
import com.parv.izdoo.exceptions.BusinessException;
@Service
public class CandidateBoImp implements CandidateBo {
	  
	  @Autowired
	  CandidateDao candidateDao; 

	public List<Candidate> getAllCandidates() {
		List<Candidate> candidates=candidateDao.getAllCandidates();
		if(candidates.isEmpty()) {
			try {
				throw new BusinessException("No candidates");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return candidates;
	}

	public void updateCandidate(Candidate candidate) {
		
		candidateDao.updateCandidate(candidate);
		
	}

	public void signupCandidate(Candidate candidate) {
		
		if(candidate.getEmail().matches("[A-Za-z0-9]{3,15}@gmail.com")) {
			if(candidate.getPassword().matches("[A-Za-z0-9]{8,}")) {
				if(candidate.getIdProof().matches("[A-Z0-9]{10,20}")) {
					
					candidateDao.signupCandidate(candidate);
			}else {
				System.out.println("Invalid Idproof");
			}
		}else {
			System.out.println("Invalid Password");
		}
		}else {
			System.out.println("Invalid Email");
		}
		
		
	}

	public Candidate login(String email, String password) throws Exception {
		 Candidate candidates=null;
		
         if(email.matches("[A-Za-z0-9]{3,15}@gmail.com") && password.matches("[A-Za-z0-9]{8,}")) {
			
			candidates = candidateDao.login(email,password);
		}
		 else {
			throw new Exception("Invalid email or password");
		} 
			return candidates;
		}

	
	public List<Candidate> getAllEligibleCandidates() {
		return candidateDao.getAllEligibleCandidates();
	}

	public Candidate getById(String candidateId) {
		return candidateDao.getById(candidateId);
	} 

}
