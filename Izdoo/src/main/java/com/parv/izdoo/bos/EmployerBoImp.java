package com.parv.izdoo.bos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parv.izdoo.daos.EmployerDao;
import com.parv.izdoo.entities.Employer;
@Service
public class EmployerBoImp implements EmployerBo {
	@Autowired
	EmployerDao employerdao;
	public void updateEmployer(Employer employer) {
		employerdao.updateEmployer(employer);
	}

	public List<Employer> getAll() {
		return employerdao.getAll();
	}

	public Employer getById(String employerId) {
		return employerdao.getById(employerId);
	}

	@Override
	public void addEmployer(Employer employer) {
		employerdao.addEmployer(employer);
		
	}

}
