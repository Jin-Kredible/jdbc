package com.bit2017.jdbc.daoTest;

import java.sql.*;
import java.util.*;

import com.bit2017.jdbc.dao.*;
import com.bit2017.jdbc.vo.*;

public class HrEmpListTest {
	public static void main(String[] args) throws SQLException {
		getList();
	}
	
	
	private static void getList() throws SQLException {
		HREmpListDao hrDao = new HREmpListDao();
		
		
		List<HREmpList> list = hrDao.getList();
		
		for(HREmpList a : list ){
			System.out.println(a);
		}
	}
}
