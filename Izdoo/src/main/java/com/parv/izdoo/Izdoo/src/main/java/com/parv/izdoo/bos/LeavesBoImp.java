package com.parv.izdoo.bos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parv.izdoo.daos.LeavesDao;
import com.parv.izdoo.entities.Leaves;
import com.parv.izdoo.exceptions.BusinessException;

@Service
public class LeavesBoImp implements LeavesBo {
	@Autowired
	LeavesDao leavedao;

	public void addLeave(Leaves leave) {
		SimpleDateFormat sd3=new SimpleDateFormat("dd-MMM-yy");
		String id1=sd3.format(leave.getLeaveDate());
		//System.out.println(id1);
		//string to date
		try {
			Date d1=sd3.parse(id1);
			leave.setLeaveDate(d1);
			System.out.println(d1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leavedao.addLeave(leave);

	}

	public void cancelLeave(int leaveId) {
		leavedao.cancelLeave(leaveId);

	}

	public void updateLeave(Leaves leave) throws BusinessException {
		if (leave.getLeaveDate().after(new Date())) {
			{
				leavedao.updateLeave(leave);
			}
		} else {
			throw new BusinessException("DATA INVALID");
		}

	}

	public List<Leaves> getAllLeaves() {
		return leavedao.getAllLeaves();
	}

	public Leaves getById(int leaveId) {
		return leavedao.getById(leaveId);
	}

}
