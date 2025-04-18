package com.m.commons;

import static com.m.commons.DBInfo.*;

import java.sql.*;

public class DBConnection {

	private static Connection con = null;

	private DBConnection() {
	}

	static {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dbUrl, uName, pWord);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Connection getCon() {
		return con;
	}

}
