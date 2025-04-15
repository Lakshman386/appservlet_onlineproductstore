package com.m.commons;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false);
		
		if(hs == null)
		{
			req.setAttribute("msg", "Session Expired...<br>");
		}
		else
		{
			hs.invalidate();  //Session Object destroyed
			req.setAttribute("msg", "LoggedOut Successfully...<br>");
		}
		
		req.getRequestDispatcher("Msg.jsp").forward(req, res);
	}
	
}
