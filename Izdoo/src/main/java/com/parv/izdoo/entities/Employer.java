package com.parv.izdoo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Employer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String employerId;
	
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String skills;
	@Column(nullable=false)
	private double experience;
	@Column(nullable=false)
	private String designation;
	
	@OneToMany(mappedBy="employer",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private List<InterviewSchedule> interviewschedules;
	
	@OneToMany(mappedBy="employer",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Leaves> leaves;
	
	
	
}
