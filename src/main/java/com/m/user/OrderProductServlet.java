package com.m.user;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.m.commons.ProductBean;

import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/order")
public class OrderProductServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false);
		
		if(hs == null)
		{
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			
			@SuppressWarnings("unchecked")
			ArrayList<ProductBean> al = (ArrayList<ProductBean>)hs.getAttribute("alist");
			
			String pCode = req.getParameter("pcode");
			
			Iterator<ProductBean> it = al.iterator();
			
			while(it.hasNext())
			{
				ProductBean pb = (ProductBean)it.next();
				
				if(pCode.equals(pb.getCode()))
				{
					float pPrice =  pb.getPrice();
					int orgQty = pb.getQty();
					int requiredQty = Integer.parseInt(req.getParameter("qty"));
					
					int newQty = orgQty - requiredQty;
					
					float totalPrice = pPrice * requiredQty;
					
					
					if(newQty > 0)
					{
						pb.setQty(newQty);
						
						int k = new OrderProductDAO().update(pb);
						
						if(k > 0)
						{
							req.setAttribute("msg", totalPrice);
							req.getRequestDispatcher("OrderSuccess.jsp").forward(req, res);;
						}
					}
					break;
				}
			}
			
		}
		
		
	}

}
