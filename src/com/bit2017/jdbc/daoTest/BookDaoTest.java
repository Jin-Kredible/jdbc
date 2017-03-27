package com.bit2017.jdbc.daoTest;

import java.sql.*;
import java.util.*;

import com.bit2017.jdbc.dao.*;
import com.bit2017.jdbc.vo.*;

public class BookDaoTest {
	public static void main(String[] args) throws SQLException {
		//insertVo();
		//searchVo();
		deleteVo();
	}
	
	
	public static void deleteVo() throws SQLException {
		BookDao bookDao = new BookDao();
		bookDao.deleteList(1L);
	}
	public static void searchVo() throws SQLException {
		BookDao bookDao = new BookDao();
		List<BookVo> list = bookDao.getList();
		
		for(BookVo a : list) {
			System.out.println(a);
		}
		
	}
	
	public static void insertVo() throws SQLException {
		
		BookVo bookVo = new BookVo();
		bookVo.setName("김진원");
		bookVo.setPubDate("2012/12/12");
		bookVo.setState("대여중");
		bookVo.setAuthNo(1);
		
		
		BookDao bookDao = new BookDao();
		
		bookDao.bookInsert(bookVo);
	}
}
