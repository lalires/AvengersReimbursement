package com.revature.bean;

public class ReimbursementType {
	
	private int rid;
	private String rtype;
	
	
	
	public ReimbursementType(int rid, String rtype) {
		this.rid = rid;
		this.rtype = rtype;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	

}
