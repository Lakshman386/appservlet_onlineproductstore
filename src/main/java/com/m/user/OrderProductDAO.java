package com.m.user;

import java.sql.*;

import com.m.commons.DBConnection;
import com.m.commons.ProductBean;

public class OrderProductDAO {
	
	int k = 0;
	
	public int update(ProductBean pb)
	{
		try {
			Connection con = DBConnection.getCon();
			
			PreparedStatement ps = con.prepareStatement("update Product58 set quantity = ? where code = ?");

			ps.setInt(1, pb.getQty());
			ps.setString(2, pb.getCode());
			
			k = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}

}
