package com.parv.izdoo.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.parv.izdoo.entities.InterviewSchedule;

@Repository
public class InterviewScheduleDaoImpl implements InterviewScheduleDao {

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void scheduleInterview(InterviewSchedule interviewSchedule) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(interviewSchedule);
		tr.commit();
		session.close();
	}

	public void updateInterview(InterviewSchedule interviewSchedule) {
		Session session = sessionFactory.openSession();		
		Transaction tr = session.beginTransaction();
		session.update(interviewSchedule);
		tr.commit();
		session.close();
	}

	public List<InterviewSchedule> getInterviewByType(String interviewType) {
		Session session = sessionFactory.openSession();
		List<InterviewSchedule> interviewSchedules = 
									(List<InterviewSchedule>) session.get(InterviewSchedule.class, interviewType);
		
		return interviewSchedules;
	}

	public InterviewSchedule getById(String interviewId) {
		Session session = sessionFactory.openSession();
		InterviewSchedule interviewSchedule = (InterviewSchedule) session.get(InterviewSchedule.class, interviewId);
		return interviewSchedule;
	}
	
	public List<InterviewSchedule> getByCandidateId(String candidateId){

		Session session = sessionFactory.openSession();
		List<InterviewSchedule> interviewSchedules =
										(List<InterviewSchedule>) session.get(InterviewSchedule.class, candidateId);
		return interviewSchedules;
	}

}
