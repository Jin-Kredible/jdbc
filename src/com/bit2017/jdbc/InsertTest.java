package com.bit2017.jdbc;

import java.sql.*;

public class InsertTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		try {
			// 1. jdbc driver loading (jdbc class loading)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connect to DB
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("연결성공");
			// 3. SQL 문 실행
			stmt = conn.createStatement();
			String sql = "insert into book values(book_seq.nextval, '토지', sysdate, '대여중', 1)";

			int s = stmt.executeUpdate(sql);
			
			if(s>0) {
				System.out.println(s +"개의 데이터 업데이트 완료");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("error: driver loading failure" + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			// 3. 자원정리
			try {
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