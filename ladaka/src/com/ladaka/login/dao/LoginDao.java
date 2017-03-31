package com.ladaka.login.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

@Repository
public class LoginDao {

	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	@Resource(name = "transactionManager")
	private PlatformTransactionManager transactionManager;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public ArrayList<HashMap<String, Object>> selectUser(Map params) {
		return (ArrayList)sqlSession.selectList("login.selectUser", params);
	}

	public ArrayList selectUserLogin(HashMap<String, Object> params) {
		return (ArrayList)sqlSession.selectList("login.selectUserLogin", params);
	}
	
	public ArrayList selectUserLogin2(HashMap<String, Object> params) {
		return (ArrayList)sqlSession.selectList("login.selectUserLogin2", params);
	}

}
