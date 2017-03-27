package com.bit2017.jdbc.dao;

import java.sql.*;
import java.util.*;

import com.bit2017.jdbc.vo.*;

public class HREmpListDao {

	public List<HREmpList> getList() throws SQLException {
		List<HREmpList> list = new ArrayList<HREmpList>();
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
			
			stmt = conn.createStatement();
			
			String sql = "select a.first_name, a.last_name, b.first_name, b.last_name from employees a, employees b where a.manager_id = b.employee_id order by a.first_name desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				String mFirstName = rs.getString(3);
				String mLastName = rs.getString(4);
				
				HREmpList listR = new HREmpList();
				listR.setFirstName(firstName);
				listR.setLastName(lastName);
				listR.setmFirstName(mFirstName);
				listR.setmLastName(mLastName);
				
				list.add(listR);
			}
			
			

		} catch (Exception e) {
			System.out.println("error " + e);
		} finally {
			if(rs!= null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
		return list;
	}
}
