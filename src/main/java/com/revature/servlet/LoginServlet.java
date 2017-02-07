package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bean.User;
import com.revature.dao.ReimbursementDAO;
@WebServlet("/Login")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 737025133711952703L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet - POST");
		HttpSession session = req.getSession();
		ReimbursementDAO rdao = new ReimbursementDAO();
		System.out.println(session.getAttribute("authState"));
		User user = new User(req.getParameter("username"), req.getParameter("password"));
		
		if(rdao.checkLogin(user)){

			session.setAttribute("authState", new Object());
			session.setAttribute("user1", rdao.setSession(user));
			User user2 = (User) session.getAttribute("user1");
			session.setAttribute("reimbursement", rdao.checkReimbursements(user2.getU_id()));
			session.setAttribute("reimbursementType", rdao.reimbursementType());
			resp.sendRedirect("Reimbursement.jsp");
		}else{			
			session.setAttribute("authState", null);
			System.out.println("Redirecting to Login.jsp");
			resp.sendRedirect("Login.jsp");
		} 
		}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet - GET");
		HttpSession session = req.getSession();
		ReimbursementDAO rdao = new ReimbursementDAO();
		System.out.println(session.getAttribute("authState"));
		if(session.getAttribute("authState")!=null)
		{
			User user2 = (User) session.getAttribute("user1");
			session.setAttribute("reimbursement", rdao.checkReimbursements(user2.getU_id()));
			System.out.println("this");
		   resp.sendRedirect("Reimbursement.jsp");
		}
		else{
		req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}
	}
	
}

