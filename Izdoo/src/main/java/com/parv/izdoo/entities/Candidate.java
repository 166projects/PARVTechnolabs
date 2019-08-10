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

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table
public class Candidate implements Serializable {
	
	
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
	private String cpassword;
	@Column(nullable=false)
	private String idProof;
	@Column(nullable=false)
	private String primarySkills;
	private String secondarySkills;
	@Column(nullable=false)
	private double experience;
	@Column(nullable=false)
	private String designation;
	@Column(nullable=false)
	private int noticePeriod;
//	@ColumnDefault(value ="eligible")
	private String eligibility;
	
	@OneToMany(mappedBy="candidate",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	private List<InterviewSchedule> interviewSchedules;
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return cpassword;
	}
	public void setPassword(String password) {
		this.cpassword = password;
	}
	public String getIdProof() {
		return idProof;
	}
	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}
	public String getPrimarySkills() {
		return primarySkills;
	}
	public void setPrimarySkills(String primarySkills) {
		this.primarySkills = primarySkills;
	}
	public String getSecondarySkills() {
		return secondarySkills;
	}
	public void setSecondarySkills(String secondarySkills) {
		this.secondarySkills = secondarySkills;
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
	public int getNoticePeriod() {
		return noticePeriod;
	}
	public void setNoticePeriod(int noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	public List<InterviewSchedule> getInterviewSchedules() {
		return interviewSchedules;
	}
	public void setInterviewSchedules(List<InterviewSchedule> interviewSchedules) {
		this.interviewSchedules = interviewSchedules;
	}
	public String getEligibility() {
		return eligibility;
	}
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}
	
}
