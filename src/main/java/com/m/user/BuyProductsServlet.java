package com.m.user;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import com.m.commons.ProductBean;

import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/buy")
public class BuyProductsServlet extends HttpServlet {
	
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
			String pCode = req.getParameter("pcode");
			ArrayList<ProductBean> al = new BuyProductsDAO().getProduct(pCode);
			hs.setAttribute("alist", al);
			
			req.getRequestDispatcher("BuyProducts.jsp").forward(req, res);
		}
	}

}
