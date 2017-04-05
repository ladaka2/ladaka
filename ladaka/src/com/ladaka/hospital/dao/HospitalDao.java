package com.ladaka.hospital.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

@Repository
public class HospitalDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	@Resource(name = "transactionManager")
	private PlatformTransactionManager transactionManager;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//Hospital
	public ArrayList<HashMap<String, Object>> selectHospitalPage(Map params) {
		return (ArrayList)sqlSession.selectList("hospital.selectHospitalPage", params);
	}
	
	public int insertHospital(HashMap<String, Object> params) {
		return sqlSession.insert("hospital.insertHospital", params);
	}
	
	public int countHospital(HashMap<String, Object> params) {
		return sqlSession.selectOne("hospital.countHospital", params);
	}
	
	public int updateHospitalApi(HashMap<String, Object> params) {
		return sqlSession.update("hospital.updateHospitalApi", params);
	}
	
	//Traffic
	public int deleteHospitalTraffic() {
		return sqlSession.delete("hospitalTraffic.deleteHospitalTraffic");
	}
	
	public int insertHospitalTraffic(HashMap<String, Object> params) {
		return sqlSession.insert("hospitalTraffic.insertHospitalTraffic", params);
	}
	
	
}
