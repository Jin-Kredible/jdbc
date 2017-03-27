package com.bit2017.jdbc;

import java.sql.*;

public class ConnectionTest {
	public static void main(String[] args) {

		Connection conn = null;

		try {
			// 1. jdbc driver loading (jdbc class loading)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connect to DB
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			System.out.println("error: driver loading failure" + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			// 3. 자원정리
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error " + e);
			}
		}
	}
}
