package com.parv.izdoo.bos;

import java.util.List;


import com.parv.izdoo.entities.Employer;
import com.parv.izdoo.entities.Leaves;

public interface EmployerBo {
	public void updateEmployer(Employer employer);
	public List<Employer> getAll();
	public Employer getById(String employerId);
	public void addEmployer(Employer employer);
}
