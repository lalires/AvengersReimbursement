package com.revature.bean;

public class User {
	
	private int U_id;
	private String U_password;
	private String U_username;
	private String U_firstname;
	private String U_lastname;
	private String U_email;
	private int UR_id;
	
	
	
	
	
	public User() {
	}



	public User(String u_username, String u_password){
		
		U_username = u_username;
		U_password = u_password;
	}
	
	
	
	public User(int u_id, String u_username, String u_password, String u_firstname, String u_lastname, String u_email,
			int uR_id) {
		super();
		U_id = u_id;
		U_password = u_password;
		U_username = u_username;
		U_firstname = u_firstname;
		U_lastname = u_lastname;
		U_email = u_email;
		UR_id = uR_id;
	}
	public int getU_id() {
		return U_id;
	}
	public void setU_id(int u_id) {
		U_id = u_id;
	}
	public String getU_password() {
		return U_password;
	}
	public void setU_password(String u_password) {
		U_password = u_password;
	}
	public String getU_username() {
		return U_username;
	}
	public void setU_username(String u_username) {
		U_username = u_username;
	}
	public String getU_firstname() {
		return U_firstname;
	}
	public void setU_firstname(String u_firstname) {
		U_firstname = u_firstname;
	}
	public String getU_lastname() {
		return U_lastname;
	}
	public void setU_lastname(String u_lastname) {
		U_lastname = u_lastname;
	}
	public String getU_email() {
		return U_email;
	}
	public void setU_email(String u_email) {
		U_email = u_email;
	}
	public int getUR_id() {
		return UR_id;
	}
	public void setUR_id(int uR_id) {
		UR_id = uR_id;
	}
	@Override
	public String toString() {
		return "User [U_id=" + U_id + ", U_password=" + U_password + ", U_username=" + U_username + ", U_firstname="
				+ U_firstname + ", U_lastname=" + U_lastname + ", U_email=" + U_email + ", UR_id=" + UR_id + "]";
	}
	
	
	
}
