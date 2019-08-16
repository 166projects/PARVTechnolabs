package com.parv.izdoo.daos;

import java.util.List;

import com.parv.izdoo.entities.Employer;

public interface EmployerDao {
	public void updateEmployer(Employer employer);
	public List<Employer> getAll();
	public Employer getById(String employerId);
	public void addEmployer(Employer employer);

}
