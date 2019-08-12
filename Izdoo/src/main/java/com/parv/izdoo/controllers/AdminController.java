package com.parv.izdoo.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.parv.izdoo.entities.Employer;
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
		List<Candidate> candidates = candidateBo.getAllEligibleCandidates();
		return candidates;
	}

	@RequestMapping(value = "/interview-schedules", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<InterviewSchedule> getAllInterviewSchedule() {
		List<InterviewSchedule> interviewSchedules = interviewScheduleBo.getAllInterviewSchedules();
		return  interviewSchedules;
	}

	@RequestMapping(value = "/leaves", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Leaves> getAllLeaves() {

		List<Leaves> leaves = leavesBo.getAllLeaves();
		return leaves;
	}

	@RequestMapping(value = "/schedule-interview", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> scheduleInterview(@RequestBody InterviewSchedule interviewSchedule) throws ParseException {
		System.out.println("controller");
		if(interviewSchedule != null){
			try {
				System.out.println("controller "+interviewSchedule.getInterviewDate());
				interviewScheduleBo.scheduleInterview(interviewSchedule);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Void>(HttpStatus.OK); 
	}
	@RequestMapping(value = "/reschedule-interview", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> rescheduleInterview(@RequestBody InterviewSchedule interviewSchedule) {
		if(interviewSchedule != null){
			try {
				InterviewSchedule is = interviewScheduleBo.getById(interviewSchedule.getInterviewId());
				is.setInterviewDate(interviewSchedule.getInterviewDate());
				interviewScheduleBo.updateInterview(is);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Void>(HttpStatus.OK); 
	}
	@RequestMapping(value = "/add-employee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addEmployee(@RequestBody Employer employer) {
		employerBo.addEmployer(employer);
	}
		
}
