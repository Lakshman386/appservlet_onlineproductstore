package com.m.user;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterUserServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		UserBean ub = new UserBean();
		
		ub.setUserName(req.getParameter("uname"));
		ub.setPassWord(req.getParameter("pword"));
		ub.setFirstName(req.getParameter("fname"));
		ub.setAddress(req.getParameter("lname"));
		ub.setAddress(req.getParameter("addr"));
		ub.setMailId(req.getParameter("mid"));
		ub.setPhoneNo(Long.parseLong(req.getParameter("phno")));
		
		int k = new RegisterUserDAO().register(ub);
		
		if(k > 0)
		{
			req.setAttribute("msg", "<h2>User Registered Successfully</h2><br>");
			
			RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
			rd.forward(req, res);
		}
		
	}

}
