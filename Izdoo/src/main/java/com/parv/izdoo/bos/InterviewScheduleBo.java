package com.parv.izdoo.bos;

import java.text.ParseException;
import java.util.List;

import com.parv.izdoo.entities.InterviewSchedule;
import com.parv.izdoo.exceptions.BusinessException;

public interface InterviewScheduleBo {
	public void scheduleInterview(InterviewSchedule interviewSchedule) throws BusinessException,ParseException;

	public void updateInterview(InterviewSchedule interviewSchedule) throws BusinessException;

	public List<InterviewSchedule> getInterviewByType(String interviewType);

	public InterviewSchedule getById(String interviewId);

	public List<InterviewSchedule> getByCandidateId(String candidateId);
	
	public List<InterviewSchedule> getAllInterviewSchedules();

}
