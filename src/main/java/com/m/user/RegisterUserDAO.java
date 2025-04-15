package com.m.user;

import java.sql.*;

import com.m.commons.DBConnection;

public class RegisterUserDAO {

	public int k = 0;
	
	public int register(UserBean ub)
	{
		try {
			
			Connection con = DBConnection.getCon();
			
			PreparedStatement ps = con.prepareStatement("insert into UserTab58 values (?,?,?,?,?,?,?)");

			ps.setString(1, ub.getUserName());
			ps.setString(2, ub.getPassWord());
			ps.setString(3, ub.getFirstName());
			ps.setString(4, ub.getLastName());
			ps.setString(5, ub.getAddress());
			ps.setString(6, ub.getMailId());
			ps.setLong(7, ub.getPhoneNo());
			
			k = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}
}
