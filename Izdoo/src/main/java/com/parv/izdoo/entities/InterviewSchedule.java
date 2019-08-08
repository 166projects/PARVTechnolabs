package com.parv.izdoo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class InterviewSchedule implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String interviewId;
	
	@Column(nullable=false)
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
}
