package com.parv.izdoo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity
@Table
public class InterviewSchedule implements Serializable, Comparable<InterviewSchedule>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String interviewId;
	
	@Column(nullable=false)
	@JsonFormat(pattern="dd-MMM-yy")
	private Date interviewDate;

	@Column(nullable=false)
	private String interviewType;

	@Column(nullable=false)
	private int rating;
	private String feedback;
	@Column(nullable=false)
	private String interviewStatus;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Candidate candidate;
	@ManyToOne(fetch=FetchType.EAGER)
	private Employer employer;
	
	
	public String getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(String interviewId) {
		this.interviewId = interviewId;
	}
	public Date getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}
	public String getInterviewType() {
		return interviewType;
	}
	public void setInterviewType(String interviewType) {
		this.interviewType = interviewType;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getInterviewStatus() {
		return interviewStatus;
	}
	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	@Override
	public int compareTo(InterviewSchedule interviewSchedule) {
		if(interviewDate.before(interviewSchedule.getInterviewDate())) return -1;
		else if(interviewDate.after(interviewSchedule.getInterviewDate()))  return 1;
		else
			return 0;
	}
	
	
}
