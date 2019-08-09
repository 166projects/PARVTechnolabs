package com.parv.izdoo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parv.izdoo.bos.CandidateBo;
import com.parv.izdoo.bos.EmployerBo;
import com.parv.izdoo.bos.InterviewScheduleBo;
import com.parv.izdoo.bos.LeavesBo;
import com.parv.izdoo.bos.UserCredentialsBo;
import com.parv.izdoo.entities.Candidate;
import com.parv.izdoo.entities.InterviewSchedule;
import com.parv.izdoo.entities.Leaves;
import com.parv.izdoo.exceptions.BusinessException;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	CandidateBo candidateBo;
	@Autowired
	EmployerBo employerBo;
	@Autowired
	InterviewScheduleBo interviewScheduleBo;
	@Autowired
	LeavesBo leavesBo;
	@Autowired
	UserCredentialsBo userCredentialsBo;

	@RequestMapping(value = "/candidates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Candidate> getAllEligibleCandidate() {
		return candidateBo.getAllEligibleCandidates();
	}

	@RequestMapping(value = "/interview-schedules", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<InterviewSchedule> getAllInterviewSchedule() {
		return interviewScheduleBo.getAllInterviewSchedules();
	}

	@RequestMapping(value = "/leaves", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Leaves> getAllLeaves() {
		return leavesBo.getAllLeaves();
	}

	@RequestMapping(value = "/schedule-interview", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void scheduleInterview(@RequestBody InterviewSchedule interviewSchedule) {
		try {
			interviewScheduleBo.scheduleInterview(interviewSchedule);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	 
}
