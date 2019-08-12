package com.parv.izdoo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.parv.izdoo.bos.CandidateBo;
import com.parv.izdoo.bos.InterviewScheduleBo;
import com.parv.izdoo.entities.Candidate;


@RestController("/candidate")

public class CandidateControllers {
	
	
	@Autowired
	CandidateBo candidateBo;
	
	@Autowired
	InterviewScheduleBo interviewScheduleBo;
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value="/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void signupCandidate(@RequestBody Candidate candidates) {
		candidateBo.signupCandidate(candidates);
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateCandidate(@RequestBody Candidate candidates) {
		candidateBo.updateCandidate(candidates);
		
	}
	
	@RequestMapping(value="/login",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Void> login(@RequestBody Candidate candidates){

           try {
               
        	   candidateBo.login(candidates.getEmail(), candidates.getPassword());

           } catch (Exception e) {

                    return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);

           }

           return new ResponseEntity<Void> (HttpStatus.OK);

    }

	
	/*@RequestMapping(value="/Apply-for-Interview/{candidateId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public void applyForInterview(@PathVariable("candidateId") String candidateId) {
		Candidate candidate = candidateBo.getById(candidateId);
		candidate.setEligibility("not elegible");
		candidateBo.updateCandidate(candidate);
		
		List<InterviewSchedule> interviewSchedules = interviewScheduleBo.getByCandidateId(candidateId);
		
	}*/
}
