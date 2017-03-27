package com.bit2017.jdbc.dao;

import java.sql.*;
import java.util.*;

import com.bit2017.jdbc.vo.*;

public class HrPracticeDao {

	public List<HrPracticeVo> getList() throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HrPracticeVo> list = new ArrayList<HrPracticeVo>();

		Scanner scanner = new Scanner(System.in);

		System.out.print("최저 연봉을 입력하세요 >");
		int minSalary = scanner.nextInt();

		System.out.print("최고 연봉을 입력하세요 >");
		int maxSalary = scanner.nextInt();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			conn = DriverManager.getConnection(url, "hr", "hr");

			String sql = "select first_name, last_name, salary from employees where salary > ? and salary < ? order by salary asc";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, minSalary);
			pstmt.setInt(2, maxSalary);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				int salary = rs.getInt(3);

				HrPracticeVo practiceVo = new HrPracticeVo();

				practiceVo.setFirstName(firstName);
				practiceVo.setLastName(lastName);
				practiceVo.setSalary(salary);

				list.add(practiceVo);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return list;

	}

}
