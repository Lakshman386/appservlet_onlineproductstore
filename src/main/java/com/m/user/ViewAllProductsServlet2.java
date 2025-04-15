package com.m.user;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.m.commons.ProductBean;
import com.m.commons.ViewAllProductsDAO;

import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/view2")
public class ViewAllProductsServlet2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false);
		
		if(hs == null)
		{
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			ArrayList<ProductBean> al = new ViewAllProductsDAO().retrieve();
			hs.setAttribute("alist", al);
			
			req.getRequestDispatcher("ViewAllProducts2.jsp").forward(req, res);
		}
		
	}

}
