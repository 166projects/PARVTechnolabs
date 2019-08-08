package com.parv.izdoo.daos;

import java.util.List;

import com.parv.izdoo.entities.InterviewSchedule;

public interface InterviewScheduleDao {
	public void scheduleInterview(InterviewSchedule interviewSchedule);

	public void updateInterview(InterviewSchedule interviewSchedule);
	
	public List<InterviewSchedule> getInterviewByType(String interviewType);
	
	public InterviewSchedule getById(String interviewId);
	
	public List<InterviewSchedule> getByCandidateId(String candidateId);
}
