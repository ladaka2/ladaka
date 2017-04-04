package com.ladaka.user.dao;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

@Repository
public class UserDao {

	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	@Resource(name = "transactionManager")
	private PlatformTransactionManager transactionManager;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public ArrayList selectUserLogin(HashMap<String, Object> params) {
		return (ArrayList) sqlSession.selectList("user.selectUserLogin", params);
	}

	public int insertUserLogin(HashMap<String, Object> params) {
		return sqlSession.insert("user.insertUserLogin", params);
	}

	public ArrayList selectUserLogin2(HashMap<String, Object> params) {
		return (ArrayList) sqlSession.selectList("user.selectUserLogin2", params);
	}
}
