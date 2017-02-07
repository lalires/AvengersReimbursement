package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bean.Reimbursement;
import com.revature.bean.ReimbursementType;
import com.revature.bean.User;


public class ReimbursementDAO implements DAO{
	static{
	    try {
	        Class.forName ("oracle.jdbc.OracleDriver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	private final static String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private final static String USERNAME = "ers_reimbursement";
	private final static String PASSWORD = "password";

	
	
	@Override
	public boolean insertNewUser(User user) {
		
		try(Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
					
			String sqlInsert = "INSERT INTO ERS_USERS(U_USERNAME, U_PASSWORD, U_FIRSTNAME, U_LASTNAME, U_EMAIL, UR_ID) VALUES(?,?,?,?,?,9)";
			CallableStatement cs = con.prepareCall(sqlInsert);
			cs.setString(1, user.getU_username());
			cs.setString(2, user.getU_password());
			cs.setString(3, user.getU_firstname());		
			cs.setString(4, user.getU_lastname());
			cs.setString(5, user.getU_email());
			try{
			cs.executeUpdate();
			return true;
			}
			catch(SQLIntegrityConstraintViolationException x){
				return false;
			}
			
			
		} catch (SQLException e) {
			return false;
		}
		
	}

	@Override
	public boolean requestReimbursement(Reimbursement r) {
		
		try(Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			System.out.println(r.getAmount() +" "+ r.getDescription() + " "+r.getAuthor() +" "+r.getRtype());
			String sqlInsert = "INSERT INTO ERS_REIMBURSEMENTS(R_AMOUNT, R_DESCRIPTION, U_ID_AUTHOR, RT_TYPE) VALUES(?,?,?,?)";
			CallableStatement cs = con.prepareCall(sqlInsert);
			cs.setDouble(1, r.getAmount());
			cs.setString(2, r.getDescription());
			cs.setInt(3,  r.getAuthor());
			cs.setInt(4,  r.getRtype());
			try{
			cs.executeUpdate();
			return true;
			}
			catch(SQLIntegrityConstraintViolationException x){
				return false;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	
	@Override
	public List<Reimbursement> checkReimbursements(int author) {

			try(Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
						List<Reimbursement> rtype = new ArrayList<>();
						String sqlInsert = "SELECT * FROM ERS_REIMBURSEMENTS WHERE U_ID_AUTHOR = ?";
						CallableStatement cs = con.prepareCall(sqlInsert);
						cs.setInt(1, author);
						try{
							ResultSet rs = cs.executeQuery();
							while(rs.next()){
								
								Reimbursement x = new Reimbursement(
								rs.getDouble(2), rs.getString(3), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
		
								rtype.add(x);
							}	
							
							return rtype;
						}
						catch(SQLIntegrityConstraintViolationException x){
							x.printStackTrace();
						}
						}
						 catch (SQLException e) {
						e.printStackTrace();
					}
			return null;
						
				}		

	
	@Override
	public boolean checkLogin(User user) {
		
		try(Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			
			String sqlInsert = "SELECT U_ID FROM ERS_USERS WHERE U_username =? AND U_password = ?";
			CallableStatement cs = con.prepareCall(sqlInsert);
			cs.setString(1, user.getU_username());
			cs.setString(2, user.getU_password());
			try{
					ResultSet rs = cs.executeQuery();
					if(rs.next()){
						return true;
					}
					else{
						return false;
					}
			
			}
			catch(SQLIntegrityConstraintViolationException x){
				return false;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Object setSession(User user) {
		
		try(Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			
			String sqlInsert = "SELECT * FROM ERS_USERS WHERE U_username =? AND U_password = ?";
			CallableStatement cs = con.prepareCall(sqlInsert);
			cs.setString(1, user.getU_username());
			cs.setString(2, user.getU_password());
			User newUser = new User();
			
			try{
				ResultSet rs = cs.executeQuery();
				if(rs.next()){
					
					newUser = new User(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getInt(7));

				}
				else{ return null; }
			
			return newUser;
			}
			catch(SQLIntegrityConstraintViolationException x){
				return null;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ReimbursementType> reimbursementType() {
try(Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			List<ReimbursementType> rtype = new ArrayList<>();
			String sqlInsert = "SELECT * FROM ERS_REIMBURSEMENT_TYPE";
			CallableStatement cs = con.prepareCall(sqlInsert);
			try{
				ResultSet rs = cs.executeQuery();
				while(rs.next()){
					
					ReimbursementType x = new ReimbursementType(
					rs.getInt(1), rs.getString(2));
					rtype.add(x);
				}	
				
				return rtype;
			}
			catch(SQLIntegrityConstraintViolationException x){
				x.printStackTrace();
			}
			}
			 catch (SQLException e) {
			e.printStackTrace();
		}
return null;
			
	}

}
