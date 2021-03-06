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
		return (ArrayList)sqlSession.selectList("hospital.selectHospitalPage2", params);
	}
	
	public ArrayList<HashMap<String, Object>> selectHospitalPageApi(Map params) {
		return (ArrayList)sqlSession.selectList("hospital.selectHospitalPageApi", params);
	}
	
	public int insertHospital(HashMap<String, Object> params) {
		return sqlSession.insert("hospital.insertHospital", params);
	}
	
	public int countHospitalApi(HashMap<String, Object> params) {
		return sqlSession.selectOne("hospital.countHospitalApi", params);
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
	
	//Subject 
	public int inserthospitalSubject(HashMap<String, Object> params) {
		return sqlSession.insert("hospitalSubject.inserthospitalSubject", params);
	}
	
	//Detail
	public int inserthospitalDetail(HashMap<String, Object> params) {
		return sqlSession.insert("hospitalDetail.inserthospitalDetail", params);
	}
	
	public ArrayList<HashMap<String, Object>> selectEmergencySearch(Map params) {
		return (ArrayList)sqlSession.selectList("hospital.selectEmergencySearch", params);
	}
	
}
