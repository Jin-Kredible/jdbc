package com.bit2017.jdbc.daoTest;

import java.sql.*;
import java.util.*;

import com.bit2017.jdbc.dao.*;
import com.bit2017.jdbc.vo.*;

public class HRSalaryTest {
	public static void main(String[] args) throws SQLException {
			getList();
	}
	
	public static void getList() throws SQLException {
		HRSalaryDao salaryDao = new HRSalaryDao();
		
		List<HRSalaryVo> list = salaryDao.getList();
		
		for(HRSalaryVo a : list) {
			System.out.println(a);
		}
		
	}
}
