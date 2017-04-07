package com.ladaka.home.dao;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

@Repository
public class HomeDao {

	@Resource(name = "sqlSession")
	private SqlSession sqlSession;

	@Resource(name = "transactionManager")
	private PlatformTransactionManager transactionManager;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public ArrayList selectNormalUser(HashMap<String, Object> params) {
		return (ArrayList) sqlSession.selectList("user.selectNormalUser", params);
	}

	public ArrayList selectBusinessUser(HashMap<String, Object> params) {
		return (ArrayList) sqlSession.selectList("user.selectBusinessUser", params);
	}
	

}
