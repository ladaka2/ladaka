package com.ladaka.common.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public Object getOne(String id, Object args) {
		return sqlSession.selectOne(id, args);
	}
	
	public int count(String id, Object args) {
		return sqlSession.selectOne(id, args);
	}
	
	public List<Object> getList(String id, Object args) {
		return sqlSession.selectList(id, args);
	}
	
	public void insert(String id, Object args) {
		sqlSession.insert(id, args);
	}
	
	public void update(String id, Object args) {
		sqlSession.update(id, args);
	}
	
	public void delete(String id, Object args) {
		sqlSession.delete(id, args);
	}
	
}
