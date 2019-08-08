package com.parv.izdoo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table
public class Leaves implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters=@Parameter(name = "sequence", value = "leave_seq"))
	@Id
	@GeneratedValue(generator="generator")
	private int leaveId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Employer employer;

	@Column(nullable=false)
	private Date leaveDate;
	private String reason;
	@Column(nullable=false)
	private String leaveApproval;
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getLeaveApproval() {
		return leaveApproval;
	}
	public void setLeaveApproval(String leaveApproval) {
		this.leaveApproval = leaveApproval;
	}
	@Override
	public String toString() {
		return "Leaves [leaveId=" + leaveId + ", employer=" + employer + ", leaveDate=" + leaveDate + ", reason="
				+ reason + ", leaveApproval=" + leaveApproval + "]";
	}
	
}
