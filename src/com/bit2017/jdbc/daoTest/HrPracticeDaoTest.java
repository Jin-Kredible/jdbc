package com.bit2017.jdbc.daoTest;

import java.sql.*;
import java.util.*;

import com.bit2017.jdbc.dao.*;
import com.bit2017.jdbc.vo.*;

public class HrPracticeDaoTest {
	public static void main(String[] args) {

		try {
			searchList();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	private static void searchList() throws SQLException{
		
		
		HrPracticeDao dao = new HrPracticeDao();
		
		
		List<HrPracticeVo> list = dao.getList();
		
		for(HrPracticeVo a : list) {
			System.out.println(a);
		}
		
	}

}
