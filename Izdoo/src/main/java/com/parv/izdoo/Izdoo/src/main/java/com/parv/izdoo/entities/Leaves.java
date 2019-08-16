	package com.parv.izdoo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;


@Entity
@Table
public class Leaves implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters=@Parameter(name = "sequence", value = "leave_seq"))
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int leaveId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Employer employer;

	@Column(nullable=false)
	//@JsonSerialize(using=JsonDateSerializer.class)
	@JsonFormat(pattern="dd-MMM-yy")
	private Date leaveDate;
	private String reason;
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
	
	
}
