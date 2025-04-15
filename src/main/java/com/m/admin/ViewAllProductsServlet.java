package com.m.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.m.commons.ProductBean;
import com.m.commons.ViewAllProductsDAO;

@SuppressWarnings("serial")
@WebServlet("/view1")
public class ViewAllProductsServlet extends HttpServlet {
	
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
			
			req.getRequestDispatcher("ViewAllProducts.jsp").forward(req, res);
		}
		
	}

}
