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

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9185504796921452908L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("RegisterServlet - POST");
		HttpSession session = req.getSession();
		ReimbursementDAO rDAO = new ReimbursementDAO();
		User user = new User(10,req.getParameter("username"),req.getParameter("password"),req.getParameter("fname"),req.getParameter("lname"),req.getParameter("email"),9);
		
		
		try{
			
			System.out.println(rDAO.insertNewUser(user));
			resp.sendRedirect("Reimbursement.jsp");
			System.out.println("new User created");

		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Username taken");
			System.out.println("Redirecting to Login.jsp");
			resp.sendRedirect("Login.jsp");
		} 
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet - GET");
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

}
