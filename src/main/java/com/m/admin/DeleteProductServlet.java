package com.m.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.m.commons.ProductBean;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
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
					it.remove(); // Remove the product from ArrayList
					
					int k = new DeleteProductDAO().delete(pb);  // Delete the product from the database
					
					if(k > 0)
					{
						req.setAttribute("msg", "Product Deleted Successfully...");
						req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);;
					}
					else
					{
						req.setAttribute("msg", "Failed to delete Product.");
				        req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);	
					}
					
					break;					
				}
			}
			
		}
		
	}

}
