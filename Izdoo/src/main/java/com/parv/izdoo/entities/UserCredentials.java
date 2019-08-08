package com.parv.izdoo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class UserCredentials implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int serialNumber;
	
	@Column(nullable=false)
	private String userType;
	

	@OneToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String loginStatus;
	
	
}
