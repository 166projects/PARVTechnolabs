package com.parv.izdoo.controllers;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateParser;
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
import com.parv.izdoo.entities.InterviewSchedule;

@RestController
@RequestMapping("/candidate")
public class CandidateControllers {

	@Autowired
	CandidateBo candidateBo;

	@Autowired
	InterviewScheduleBo interviewScheduleBo;

	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
*/
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void signupCandidate(@RequestBody Candidate candidates) {
		candidateBo.signupCandidate(candidates);
	}

	@RequestMapping(value = "/add", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateCandidate(@RequestBody Candidate candidates) {
		candidateBo.updateCandidate(candidates);

	}

	/*@RequestMapping(value = "/login/{email}/{password}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> login(@PathVariable("email") String email, @PathVariable("password") String password) {

		try {

			candidateBo.login(email, password);

		} catch (Exception e) {

			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);

		}

		return new ResponseEntity<Void>(HttpStatus.OK);

	}*/

	@RequestMapping(value = "/ApplyforInterview/{candidateId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void applyForInterview(@PathVariable("candidateId") String candidateId) {
		Candidate candidate = candidateBo.getById(candidateId);
		candidate.setEligibility("not eligible");
		candidateBo.updateCandidate(candidate);

		List<InterviewSchedule> interviewSchedules = interviewScheduleBo.getByCandidateId(candidate.getCandidateId());
		interviewSchedules.sort(Comparator.comparing(e -> e.getInterviewDate()));
		Collections.reverse(interviewSchedules);

		InterviewSchedule interviewSchedule = interviewSchedules.get(0); 
		LocalDate d = LocalDate.now();
		Calendar cal = Calendar.getInstance();
		cal.setTime(interviewSchedule.getInterviewDate());
		LocalDate date = LocalDate.of(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH) + 1,
		        cal.get(Calendar.DAY_OF_MONTH));
		LocalDate d1 ;
		//LocalDate d1=new LocalDateParser(interviewSchedule);
		Period diff = Period.between(date, d);
		try {
			if (diff.getDays() > 30) {

				candidateBo.updateCandidate(candidate);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}

