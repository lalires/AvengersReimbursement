package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.bean.Reimbursement;
import com.revature.dao.ReimbursementDAO;

@WebServlet("/Submit")
public class SubmitServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("SubmitServlet - POST");
		
		resp.setContentType("String");
		
		PrintWriter pw = resp.getWriter();
		int author = Integer.parseInt(req.getParameter("author"));
		int type = Integer.parseInt(req.getParameter("rtype"));
		Reimbursement re = new Reimbursement(Double.parseDouble(req.getParameter("amount")), req.getParameter("description"),author, type);
		
		ReimbursementDAO dao = new ReimbursementDAO();
		
		if(dao.requestReimbursement(re)){
			pw.write("Request for Reimbursement Sent");
		}
		
		
		
		
	}

	
}