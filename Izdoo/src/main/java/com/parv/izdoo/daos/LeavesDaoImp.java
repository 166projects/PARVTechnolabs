package com.parv.izdoo.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.parv.izdoo.entities.Leaves;
@Repository
public class LeavesDaoImp implements LeavesDao {
	@Autowired
	SessionFactory sessionFactory;
	public void setSesssionFactory(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	public void addLeave(Leaves leave) {
		
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(leave);
		tr.commit();
		session.close();
		
	}

	public void cancelLeave(int leaveId) {
		
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(leaveId);
		tr.commit();
		session.close();
	}

	public void updateLeave(Leaves leave) {

		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(leave);
		tr.commit();
		session.close();
		
	}

	public List<Leaves> getAllLeaves() {
		List<Leaves> leaves=null;
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		leaves=(List<Leaves>)session.createCriteria(Leaves.class).list();
		tr.commit();
		session.close();
		return leaves;
	}

	

	public Leaves getById(int leaveId) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Leaves leaves=(Leaves)session.createCriteria(Leaves.class).add(Restrictions.eq("leaveId",leaveId));
		tr.commit();
		session.close();
		return leaves;
	}

}
