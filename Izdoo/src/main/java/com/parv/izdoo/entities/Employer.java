package com.parv.izdoo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;

 

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.parv.izdoo.util.StringPrefixedSequenceIdGenerator;


@Entity
public class Employer implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @Column(nullable=false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prav_seq")
    @GenericGenerator(
             name = "prav_seq",
             strategy = "com.parv.izdoo.util.StringPrefixedSequenceIdGenerator",
             parameters = {
                       @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                       @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "EM00"),
                       @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d")})
    
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
	
	
	public String getEmployerId() {
		return employerId;
	}

	public void setEmployerId(String employerId) {
		this.employerId = employerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public double getExperience() {
		return experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public List<InterviewSchedule> getInterviewschedules() {
		return interviewschedules;
	}

	public void setInterviewschedules(List<InterviewSchedule> interviewschedules) {
		this.interviewschedules = interviewschedules;
	}

	public List<Leaves> getLeaves() {
		return leaves;
	}

	public void setLeaves(List<Leaves> leaves) {
		this.leaves = leaves;
	}
}
