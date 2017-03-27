package com.bit2017.jdbc;

import java.sql.*;

public class UpdateTest {
	public static void main(String[] args) {
			try {
				updateBook(1L, "토지1", true );
				updateBook(2L, "토지2", false );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
	}
	
	public static void updateBook( Long no, String title, boolean rent) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. jdbc driver loading (jdbc class loading)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connect to DB
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			System.out.println("error: driver loading failure" + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			// 3. SQL문 준비
			
			String sql = "update book set title =?, state=? where no=?";
			
			pstmt = conn.prepareStatement(sql);
			
			//4. 데이터 바인딩
			
			pstmt.setString(1, title );
			pstmt.setString(2, rent ? "대여중" : "대여가능");
			pstmt.setLong(3, no);
			
			//5. sql문 실행
			int count = pstmt.executeUpdate();
			
			if (count ==1) {
				System.out.println("update 성공");
			
			
			
			try {
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
}
