package com.ladaka.mypage.dao;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

@Repository
public class MypageDao {

	@Resource(name = "sqlSession")
	private SqlSession sqlSession;

	@Resource(name = "transactionManager")
	private PlatformTransactionManager transactionManager;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
}
