package com.m.admin;

import java.sql.*;

import com.m.commons.DBConnection;

public class AdminLoginDAO {

	public AdminBean ab = null;

	public AdminBean login(String uN, String pW) {
		try {

			Connection con = DBConnection.getCon();

			PreparedStatement ps = con.prepareStatement("select * from AdminTab58 where uname = ? and pword = ?");

			ps.setString(1, uN);
			ps.setString(2, pW);

			ResultSet rs = ps.executeQuery(); // cursor object

			if (rs.next()) {
				ab = new AdminBean();

				ab.setuName(rs.getString(1));
				ab.setpWord(rs.getString(2));
				ab.setfName(rs.getString(3));
				ab.setlName(rs.getString(4));
				ab.setAddr(rs.getString(5));
				ab.setMid(rs.getString(6));
				ab.setPhNo(rs.getLong(7));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ab;
	}
}
