package com.parv.izdoo.daos;

import java.util.List;

import com.parv.izdoo.entities.Candidate;

public interface CandidateDao {

	public List<Candidate> getAllCandidates();
	public List<Candidate> getAllEligibleCandidates();
	public Candidate getById(String candidateId);
	public void  updateCandidate(Candidate candidate);
	public void  signupCandidate(Candidate candidate);
	public  Candidate login(String email,String password) throws Exception;
}