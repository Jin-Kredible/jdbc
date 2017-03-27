package com.bit2017.jdbc.dao;

import java.sql.*;
import java.util.*;

import com.bit2017.jdbc.vo.*;

public class HRSalaryDao {

public List<HRSalaryVo> getList() throws SQLException {
	List<HRSalaryVo> list = new ArrayList<HRSalaryVo>();
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	Scanner scanner = new Scanner(System.in);
	System.out.print("최고 연봉을 입력하세요 :");
	int maxSalary = scanner.nextInt();
	System.out.print("최저 연봉을 입력하세요 :");
	int minSalary = scanner.nextInt();

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(url, "hr", "hr");
		System.out.println("연결성공");
		
		stmt = conn.createStatement();
		
		String sql = "select first_name, Last_name, salary from employees where salary > '"+ minSalary + "' and salary < '"+ maxSalary + "' order by salary asc ";
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			String firstName = rs.getString(1);
			String lastName = rs.getString(2);
			int salary = rs.getInt(3);
			
			HRSalaryVo salaryVo = new HRSalaryVo();
			salaryVo.setFirstName(firstName);
			salaryVo.setLastName(lastName);
			salaryVo.setSalary(salary);
			
			list.add(salaryVo);
		}
		
		
	}	catch (Exception e){
		System.out.println("error : " + e);
	}finally {
		if(rs!=null){
			rs.close();
		}
		if(stmt!=null){
			stmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
	return list;
}
	
}
