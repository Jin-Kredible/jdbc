package com.bit2017.jdbc.daoTest;

import java.util.*;

import com.bit2017.jdbc.dao.*;
import com.bit2017.jdbc.vo.*;

public class AuthorDaoTest {
	public static void main(String[] args) {
		insertTest();
		getList();
		delete();
	}
	
	private static void insertTest()  {
		//mock data
		
		AuthorVo vo = new AuthorVo();
		vo.setName("김경리");
		vo.setContent("Okay Bari");
		
		AuthorDao dao = new AuthorDao();
		
		dao.insert(vo);
	}
	
	private static void getList() {
		AuthorDao dao = new AuthorDao();
		List<AuthorVo> list = dao.getList();
		
		
		for (AuthorVo vo : list) {
		System.out.println(vo);
		}
	}
	
	private static void delete() {
		AuthorDao dao = new AuthorDao();
		
		dao.delete( 2L );
	}
}
