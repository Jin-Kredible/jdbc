package com.bit2017.jdbc.dao;

import java.sql.*;
import java.util.*;

import com.bit2017.jdbc.vo.*;

public class BookDao {
	
	public boolean deleteList(Long no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("연결성공");
			String sql = "delete from book where no=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, no);
			int count = pstmt.executeUpdate();
		
			return(count==1);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(pstmt!= null) {
				pstmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
			
		}
			
	}

	public List<BookVo> getList() throws SQLException {

		List<BookVo> list = new ArrayList<BookVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("연결성공");

			String sql = "select no, title, pub_Date, state, author_No from book";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String pubDate = rs.getString(3);
				String state = rs.getString(4);
				int authNo = rs.getInt(5);

				BookVo bookVo = new BookVo();
				bookVo.setNo(no);
				bookVo.setName(name);
				bookVo.setPubDate(pubDate);
				bookVo.setState(state);
				bookVo.setAuthNo(authNo);

				list.add(bookVo);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!= null) {
				rs.close();
			}
			if(stmt!= null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
			
		}
		return list;
	}

	public boolean bookInsert(BookVo bookVo) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("연결성공");
			String sql = "insert into book values(book_seq.nextval, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bookVo.getName());
			pstmt.setString(2, bookVo.getPubDate());
			pstmt.setString(3, bookVo.getState());
			pstmt.setInt(4, bookVo.getAuthNo());

			int count = pstmt.executeUpdate();

			if (count == 1) {
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException e) {
			System.out.println("클래스 낫 파운드 오류 " + e);
			return false;
		} finally {
			if (conn != null) {
				conn.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}
}
