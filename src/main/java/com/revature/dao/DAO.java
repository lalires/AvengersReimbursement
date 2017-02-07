package com.revature.dao;

import java.util.List;

import com.revature.bean.Reimbursement;
import com.revature.bean.ReimbursementType;
import com.revature.bean.User;

public interface DAO {
	
	
	boolean insertNewUser(User user);
	boolean requestReimbursement(Reimbursement r);
	List<ReimbursementType> reimbursementType();
	List<Reimbursement> checkReimbursements(int author);
	boolean checkLogin(User user);
	
	
	

}
