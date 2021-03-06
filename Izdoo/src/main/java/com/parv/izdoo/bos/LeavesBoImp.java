package com.parv.izdoo.bos;

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
