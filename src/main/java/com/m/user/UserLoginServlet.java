package com.m.user;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/user")
public class UserLoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String uN = req.getParameter("uname");
		String pW = req.getParameter("pword");
		
		UserBean ub = new UserLoginDAO().login(uN, pW);
		
		if(ub == null)
		{
			req.setAttribute("msg", "Invalid Login Process...<br>");
			req.getRequestDispatcher("Msg.jsp");
		}
		else
		{
			HttpSession hs = req.getSession();  //Creating Session when Login Success
			hs.setAttribute("ubean", ub);
			
			req.getRequestDispatcher("UserLoginSuccess.jsp").forward(req, res);
		}
	}

}
