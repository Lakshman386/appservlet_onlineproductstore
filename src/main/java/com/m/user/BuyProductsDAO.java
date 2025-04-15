package com.m.user;

import java.sql.*;
import java.util.*;

import com.m.commons.DBConnection;
import com.m.commons.ProductBean;

public class BuyProductsDAO {

	public ArrayList<ProductBean> al = new ArrayList<ProductBean>();
	
	public ArrayList<ProductBean> getProduct(String code)
	{
		try {
			
			Connection con = DBConnection.getCon();
			
			PreparedStatement ps = con.prepareStatement("select * from Product58 where code = ?");
			
			ps.setString(1, code);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				ProductBean pb = new ProductBean();
				
				pb.setCode(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getFloat(3));
				pb.setQty(rs.getInt(4));
				
				al.add(pb);  //Bean added to ArrayList
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return al;
	}
}
