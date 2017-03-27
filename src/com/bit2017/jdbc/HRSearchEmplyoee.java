package com.bit2017.jdbc;

import java.sql.*;
import java.util.*;

public class HRSearchEmplyoee {
	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);
		// 키워드 입력
		System.out.print("입력 > ");
		String keyword = scanner.nextLine();
		String keyword2 = scanner.nextLine();

		// 검색
		searchEmployees(keyword);
		searchEmployees(keyword2);

		scanner.close();

	}

	private static void searchEmployees(String keyword) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

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
			// 3. SQL문 준비

			String sql = "select first_name || ' ' || last_name,"
					+ "email, phone_number, to_char(hire_date, 'yyyy-mm-dd') from employees where first_name like ? "
					+ " or last_name like ?";

			pstmt = conn.prepareStatement(sql);

			// 4. 데이터 바인딩

			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");

			// 5. sql문 실행
			rs = pstmt.executeQuery();

			while (rs.next()) {

				String name = rs.getString(1);
				String email = rs.getString(2);
				String phone_number = rs.getString(3);
				String hire_date = rs.getString(4);

				System.out.println(name + ": " + email + ":" + phone_number + ":" + hire_date + "");
			}

			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
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
