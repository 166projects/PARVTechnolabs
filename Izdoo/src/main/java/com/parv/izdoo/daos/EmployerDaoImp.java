package com.parv.izdoo.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.parv.izdoo.entities.Employer;
import com.parv.izdoo.entities.Leaves;
@Repository
public class EmployerDaoImp implements EmployerDao {
	@Autowired
	SessionFactory sessionFactory;
	public void setSesssionFactory(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	public void updateEmployer(Employer employer) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(employer);
		tr.commit();
		session.close();

	}

	public List<Employer> getAll(){
		List<Employer> employer=null;
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		employer=(List<Employer>)session.createCriteria(Employer.class).list();
		tr.commit();
		session.close();
		return employer;
		
	}

	public Employer getById(String employerId) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Employer employer=(Employer)session.createCriteria(Employer.class).add(Restrictions.eq("employerId",employerId));
		tr.commit();
		session.close();
		return employer;
	}

	

}
