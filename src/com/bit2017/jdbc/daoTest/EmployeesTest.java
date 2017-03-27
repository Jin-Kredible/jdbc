package com.bit2017.jdbc.daoTest;

import java.util.*;

import com.bit2017.jdbc.dao.*;
import com.bit2017.jdbc.vo.*;

public class EmployeesTest {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름 입력 >");
		String name = scanner.nextLine();
		
		List<EmployeesVo> list = searchEmployees(name);
		displayEmployees(list);
		
		
	}

	private static List<EmployeesVo> searchEmployees(String keyword) {
		EmployeesDao dao = new EmployeesDao();

		List<EmployeesVo> list = dao.getEmployees(keyword);
		return list;
	}

	private static void displayEmployees(List<EmployeesVo> list) {
		for (EmployeesVo a : list) {
			System.out.println(
			a.getFirstName()
		);	
		}
	}
}
