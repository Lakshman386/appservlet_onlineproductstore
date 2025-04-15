package com.m.admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{ 
		String uN = req.getParameter("uname");
		String pW = req.getParameter("pword");
		
		AdminBean ab = new AdminLoginDAO().login(uN, pW);
		
		if(ab == null)
		{
			req.setAttribute("msg", "Invalid Login Process...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			HttpSession hs = req.getSession();  // Creating new Session
			hs.setAttribute("abean", ab);  //AdminBean added to Session
			
			req.getRequestDispatcher("AdminLoginSuccess.jsp").forward(req, res);
		}
	}

}
