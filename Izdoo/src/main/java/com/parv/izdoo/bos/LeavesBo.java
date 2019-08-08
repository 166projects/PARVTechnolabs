package com.parv.izdoo.bos;

import java.util.List;

import com.parv.izdoo.entities.Leaves;
import com.parv.izdoo.exceptions.BusinessException;

public interface LeavesBo {
   
	    public void addLeave(Leaves leave);
	    public void cancelLeave(int leaveId);
	    public void updateLeave(Leaves leave);
	    public List<Leaves> getAll();
	    public Leaves getById(int leaveId);
}
