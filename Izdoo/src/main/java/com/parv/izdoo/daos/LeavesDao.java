package com.parv.izdoo.daos;

import java.util.List;



import com.parv.izdoo.entities.Leaves;


public interface LeavesDao {
    public void addLeave(Leaves leave);
    public void cancelLeave(int leaveId);
    public void updateLeave(Leaves leave);
    public List<Leaves> getAll();
    public Leaves getById(int leaveId);
}
