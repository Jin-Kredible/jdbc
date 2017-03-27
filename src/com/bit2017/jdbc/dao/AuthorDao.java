package com.bit2017.jdbc.dao;

import java.sql.*;
import java.util.*;

import com.bit2017.jdbc.vo.*;

public class AuthorDao {

	public boolean delete() {

		return true;
	}

	public boolean delete(Long no) {

		Connection conn = null;
		Statement stmt = null;

		try {
			// 1. jdbc driver loading (jdbc class loading)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connect to DB
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("연결성공");

			// 3. sql문 준비
			stmt = conn.createStatement();

			String sql = "delete from author where no='" + no + "'";

			// 5. execute sql

			int count = stmt.executeUpdate(sql);

			return (count == 1);

		} catch (ClassNotFoundException e) {
			System.out.println("error: driver loading failure" + e);
			return false;
		} catch (SQLException e) {
			System.out.println("error: " + e);
			return false;
		} finally {

			try {
				if (stmt != null) {
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

	public boolean insert(AuthorVo authorVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. jdbc driver loading (jdbc class loading)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connect to DB
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("연결성공");

			// 3. sql문 준비

			String sql = "insert into author values(author_seq.nextval, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			// 4. Binding

			pstmt.setString(1, authorVo.getName());
			pstmt.setString(2, authorVo.getContent());

			// 5. execute sql

			int count = pstmt.executeUpdate();

			return (count == 1);

		} catch (ClassNotFoundException e) {
			System.out.println("error: driver loading failure" + e);
			return false;
		} catch (SQLException e) {
			System.out.println("error: " + e);
			return false;
		} finally {

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

	public List<AuthorVo> getList() {
		List<AuthorVo> list = new ArrayList<AuthorVo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. jdbc driver loading (jdbc class loading)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connect to DB
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("연결성공");

			// 3. sql문 준비
			stmt = conn.createStatement();

			String sql = "select no, name, content from author";

			// 5. execute sql

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String content = rs.getString(3);

				AuthorVo authorvo = new AuthorVo();
				authorvo.setNo(no);
				authorvo.setName(name);
				authorvo.setContent(content);

				list.add(authorvo);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("error: driver loading failure" + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error " + e);
			}
		}

		return list;
	}

}
