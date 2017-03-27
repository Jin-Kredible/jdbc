package com.bit2017.jdbc.dao;

import java.sql.*;
import java.util.*;

import com.bit2017.jdbc.vo.*;

public class EmployeesDao {

	public static List<EmployeesVo> getEmployees() {
		return null;
		
	}
	
	public static List<EmployeesVo> getEmployees(String keyword) {
		List<EmployeesVo> list = new ArrayList<EmployeesVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			String sql = "select first_name from employees where first_name like ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+keyword+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String firstName = rs.getString(1);
				
				EmployeesVo vo = new EmployeesVo();
				
				vo.setFirstName(firstName);
				
				list.add(vo);
				
				
				
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return list;
		
		
	}
	
	
}
