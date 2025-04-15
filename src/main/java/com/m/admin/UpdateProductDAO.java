package com.m.admin;

import java.sql.*;

import com.m.commons.DBConnection;
import com.m.commons.ProductBean;

public class UpdateProductDAO {
	
	int k = 0;
	
	public int update(ProductBean pb)
	{
		try {
			Connection con = DBConnection.getCon();
			
			PreparedStatement ps = con.prepareStatement("update Product58 set price = ?, quantity = ? where code = ?");

			ps.setFloat(1, pb.getPrice());
			ps.setInt(2, pb.getQty());
			ps.setString(3, pb.getCode());
			
			k = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}

}
