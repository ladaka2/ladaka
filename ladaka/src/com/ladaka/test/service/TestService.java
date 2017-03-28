package com.ladaka.test.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ladaka.test.dao.TestDao;

@Service
//@Transactional(readOnly=false)
public class TestService {
	
	@Autowired
	TestDao testDao;
	
	//@Transactional
	public ArrayList<HashMap<String, Object>> test(HashMap<String, Object> params) {
		//testDao.deleteHospitalDetail(params);
		return (ArrayList)testDao.selectHospital(params);
	}
}
