package com.bit2017.jdbc;

import java.sql.*;

public class SelectTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. jdbc driver loading (jdbc class loading)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connect to DB
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("연결성공");
			// 3. SQL 문 실행
			stmt = conn.createStatement();
			String sql = "select employee_id, first_name, last_name, salary from employees";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long employeeId = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				int salary = rs.getInt(4);
				
				System.out.println(
					"Employee Id=" +  employeeId + 
					" First Name =  " +  firstName  +
					" Last Name = " + lastName + 
					" Salary = " + salary);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("error: driver loading failure" + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			// 3. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();			
				}
			} catch (SQLException e) {
				System.out.println("error " + e);
			}
		}
	}
}
