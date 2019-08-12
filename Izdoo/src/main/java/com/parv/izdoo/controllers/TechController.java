package com.parv.izdoo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parv.izdoo.bos.InterviewScheduleBo;
import com.parv.izdoo.bos.LeavesBo;

import com.parv.izdoo.entities.Candidate;
import com.parv.izdoo.entities.InterviewSchedule;
import com.parv.izdoo.entities.Leaves;
import com.parv.izdoo.exceptions.BusinessException;

@RestController
@RequestMapping("/Tech")
public class TechController {

	@Autowired
	InterviewScheduleBo interviewScheduleBo;
	@Autowired
	LeavesBo leavesBo;
	
	@RequestMapping(value="/getInterviewByType", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<InterviewSchedule> getInterviewByType(/*@PathVariable ("interviewType")String interviewType*/){	
		return interviewScheduleBo.getInterviewByType("TECH");
	}
	
	@RequestMapping(value="/updateRatings", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateInterview(@RequestBody InterviewSchedule interviewSchedule) throws BusinessException{	
		
		InterviewSchedule interview = interviewScheduleBo.getById(interviewSchedule.getInterviewId());
		
		if(interview !=null) {
				interviewScheduleBo.updateInterview(interviewSchedule);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateStatus", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateInterview1(@RequestBody InterviewSchedule interviewSchedule) throws BusinessException{	
		
		InterviewSchedule interview = interviewScheduleBo.getById(interviewSchedule.getInterviewId());
		
		if(interview !=null) {
				interviewScheduleBo.updateInterview(interviewSchedule);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@RequestMapping(value = "/add-Leave", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addLeave(@RequestBody Leaves leave) {
		leavesBo.addLeave(leave);
}
}

