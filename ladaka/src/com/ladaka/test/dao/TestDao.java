package com.ladaka.test.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

@Repository
//@Transactional(readOnly=true)
public class TestDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	@Resource(name = "transactionManager")
	private PlatformTransactionManager transactionManager;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//@Transactional
	public ArrayList<HashMap<String, Object>> selectHospital(Map params) {
		return (ArrayList)sqlSession.selectList("test.selectHospital", params);
		/* 
		ArrayList list = null;
		try {
			list = (ArrayList)sqlSession.selectList("test.selectHospital");
			throw new RuntimeException("강제로 오류를 발생시켜봄!!");
		} catch(Exception e) {
			System.out.println("catch L34");
			e.printStackTrace();
		}
		return list;
		*/
	}
	
	
	//@Transactional
	public int deleteHospitalDetail(Map params) {
		return (int)sqlSession.delete("test.deleteHospitalDetail", params);
	}
	
}
