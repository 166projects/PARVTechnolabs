package com.parv.izdoo.bos;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parv.izdoo.daos.CandidateDao;
import com.parv.izdoo.daos.InterviewScheduleDao;
import com.parv.izdoo.entities.Candidate;
import com.parv.izdoo.entities.InterviewSchedule;
import com.parv.izdoo.exceptions.BusinessException;

@Service
public class CandidateBoImp implements CandidateBo {

	@Autowired
	CandidateDao candidateDao;

	@Autowired
	InterviewScheduleDao interviewScheduleDao;

	public List<Candidate> getAllCandidates() {
		List<Candidate> candidates = candidateDao.getAllCandidates();
		if (candidates.isEmpty()) {
			try {
				throw new BusinessException("No candidates");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return candidates;
	}

	public void updatingCandidate(Candidate candidate) {
		candidateDao.updateCandidate(candidate);
	}

	@Transactional
	public void updateCandidate(String candid) {
		Candidate candidate = candidateDao.getById(candid);
		candidate.setEligibility("not eligible");
		candidateDao.updateCandidate(candidate);

		List<InterviewSchedule> interviewSchedules = interviewScheduleDao.getByCandidateId(candidate.getCandidateId());
		interviewSchedules.sort(Comparator.comparing(e -> e.getInterviewDate()));
		Collections.reverse(interviewSchedules);
		System.out.println("print");
		InterviewSchedule interviewSchedule = interviewSchedules.get(0);
		LocalDate curDate = LocalDate.now();

		LocalDate interviewDate = interviewSchedule.getInterviewDate().toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate();

		long period = ChronoUnit.DAYS.between(interviewDate, curDate);

		try {
			if (period > 30) {
				candidate.setEligibility("eligible");
				candidateDao.updateCandidate(candidate);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void signupCandidate(Candidate candidate) {

		if (candidate.getEmail().matches("[A-Za-z0-9]{3,15}@gmail.com")) {
			if (candidate.getPassword().matches("[A-Za-z0-9]{8,}")) {
				if (candidate.getIdProof().matches("[A-Z0-9]{10,20}")) {

					candidateDao.signupCandidate(candidate);
				} else {
					System.out.println("Invalid Idproof");
				}
			} else {
				System.out.println("Invalid Password");
			}
		} else {
			System.out.println("Invalid Email");
		}

	}

	public Candidate login(String email, String password) throws Exception {
		Candidate candidates = null;

		if (email.matches("[A-Za-z0-9]{3,15}@gmail.com") && password.matches("[A-Za-z0-9]{8,}")) {

			candidates = candidateDao.login(email, password);
		} else {
			throw new Exception("Invalid email or password");
		}
		return candidates;
	}

	public List<Candidate> getAllEligibleCandidates() {
		return candidateDao.getAllEligibleCandidates();
	}

	public Candidate getById(String candidateId) {
		return candidateDao.getById(candidateId);
	}

}
