package com.parv.izdoo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table
public class Candidate implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String candidateId;
	
	@Column(nullable=false)
	private String firstName;
	@Column(nullable=false)
	private String lastName;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private long idProof;
	@Column(nullable=false)
	private String primarySkills;
	private String secondarySkills;
	@Column(nullable=false)
	private double experience;
	@Column(nullable=false)
	private String designation;
	@Column(nullable=false)
	private int noticePeriod;		//in days 
	
	@OneToMany(mappedBy="candidate",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	private List<InterviewSchedule> interviewSchedules;
}
