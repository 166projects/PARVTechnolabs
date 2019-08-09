package com.parv.izdoo.bos;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parv.izdoo.daos.InterviewScheduleDao;
import com.parv.izdoo.entities.InterviewSchedule;
import com.parv.izdoo.exceptions.BusinessException;

@Service
public class InterviewScheduleBoImpl implements InterviewScheduleBo{

	@Autowired
	InterviewScheduleDao interviewScheduleDao;
	
	
	public void scheduleInterview(InterviewSchedule interviewSchedule) throws BusinessException {
		if (interviewSchedule.getInterviewDate().after(new Date())) {
			interviewScheduleDao.scheduleInterview(interviewSchedule);
		} else {
			throw new BusinessException("Invalid date Input!!!");
		}
	}

	public void updateInterview(InterviewSchedule interviewSchedule) throws BusinessException {
		if (interviewSchedule.getInterviewDate().after(new Date())) {
			interviewScheduleDao.updateInterview(interviewSchedule);
		} else {
			throw new BusinessException("Invalid date Input!!!");
		}	
	}

	public List<InterviewSchedule> getInterviewByType(String interviewType) {
		List<InterviewSchedule> interviewSchedules =interviewScheduleDao.getInterviewByType(interviewType);
		return interviewSchedules;
	}

	public InterviewSchedule getById(String interviewId) {
		return interviewScheduleDao.getById(interviewId);
	}

	public List<InterviewSchedule> getByCandidateId(String candidateId) {
		return interviewScheduleDao.getByCandidateId(candidateId);
	}

	public List<InterviewSchedule> getAllInterviewSchedules() {
		return interviewScheduleDao.getAllInterviewSchedules();
	}

}
