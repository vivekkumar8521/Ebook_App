package com.user.servlet;

import java.io.IOException;
import java.sql.Connection;

import com.DAO.UserDAOImpl;
import com.DB.DBConnect;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private Object check;
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private Object stmt;
	private Connection conn;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
		
		try {
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String phno=request.getParameter("phno");
			String password=request.getParameter("password");
			String address=request.getParameter("address");
			
			// System.out.println(name+" "+email+" "+phno+" "+password+" ");
			
			
			User user=new User();
			user.setName(name);
			user.setEmail(email);
			user.setPhno(phno); 
			user.setPassword(password);
			user.setAddress(address);
			
			
			//HttpSession session=req.getSession();
			 
			//if(check!=null) {
				
			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
			boolean f=dao.userRegister(user);
			
			if(f)   
			{
				//System.out.println("User Register Success");
				//session.setAttribute("SuccMsg","Registration Successfully");
				//resp.sendRedirect("register.jsp");
				response.getWriter().println("Signup Successful!");
				
			}
			
			else
			{
				//System.out.println("Something Error");
				//session.setAttribute("failedMsg","Something Error");
				//resp.sendRedirect("register.jsp");
				response.getWriter().println("Signup Failed.");
			}
		//	}
		//	else
			{
				//System.out.println("Please Check Agree & Terms Condition");
				//session.setAttribute("failedMsg","Please Check Agree & Terms Condition");
				//resp.sendRedirect("register.jsp");
			}
			
		}
		 
		catch(Exception e) {
			
		}
		
		
	}
	
	

}
