package com.m.admin;

import java.sql.*;

import com.m.commons.DBConnection;
import com.m.commons.ProductBean;

public class DeleteProductDAO {

	int k = 0;
	
	public int delete(ProductBean pb)
	{
		try {
			
			Connection con = DBConnection.getCon();
			
			PreparedStatement ps = con.prepareStatement("delete from Product58 where code = ?");
			
			ps.setString(1, pb.getCode());
			
			k = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}
}
