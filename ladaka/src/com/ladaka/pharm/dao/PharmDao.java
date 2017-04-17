package com.ladaka.pharm.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;


@Repository
public class PharmDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	@Resource(name = "transactionManager")
	private PlatformTransactionManager transactionManager;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insertPharm(HashMap<String, Object> params) {
		return sqlSession.insert("pharm.insertPharm", params);
	}
	
	public ArrayList<HashMap<String, Object>> selectPharmPage(Map params) {
		return (ArrayList)sqlSession.selectList("pharm.selectPharmPage", params);
	}
	
}
