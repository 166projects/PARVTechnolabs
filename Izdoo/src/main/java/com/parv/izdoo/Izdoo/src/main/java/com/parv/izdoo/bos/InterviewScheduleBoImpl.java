package com.parv.izdoo.bos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parv.izdoo.daos.InterviewScheduleDao;
import com.parv.izdoo.daos.LeavesDao;
import com.parv.izdoo.entities.InterviewSchedule;
import com.parv.izdoo.entities.Leaves;
import com.parv.izdoo.exceptions.BusinessException;

@Service
public class InterviewScheduleBoImpl implements InterviewScheduleBo {

	@Autowired
	InterviewScheduleDao interviewScheduleDao;
	@Autowired
	LeavesDao leavesDao;

	public void scheduleInterview(InterviewSchedule interviewSchedule) throws BusinessException, ParseException {
		if ((interviewSchedule.getInterviewDate()).after(new Date())) {

			List<Leaves> leaves = leavesDao.getAllLeaves();
			List<Date> leaveDates = leaves.stream().filter(p -> p.getLeaveDate().after(new Date()))
					.map(p1 -> p1.getLeaveDate()).collect(Collectors.toList());

			
			// date to string
			SimpleDateFormat sd3=new SimpleDateFormat("yyyy-MM-dd");
			String id1=sd3.format(interviewSchedule.getInterviewDate());
			//System.out.println(id1);
			//string to date
			Date d1=sd3.parse(id1);

			boolean s= leaveDates.contains(d1);
			/*System.out.println(d1);
			System.out.println(Collections.binarySearch(leaveDates, d1)+" search operatins");
			System.out.println(s);*/
			if(s) {
				throw new BusinessException("Employer not Available, please select different date for Interview.");
			}else {
				interviewScheduleDao.scheduleInterview(interviewSchedule);
			}


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
		List<InterviewSchedule> interviewSchedules = interviewScheduleDao.getInterviewByType(interviewType);
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
