package com.ladaka.hospital.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladaka.hospital.dao.HospitalDao;

@Service
public class HospitalService {
	
	@Autowired
	HospitalDao hospitalDao;
	
	public int insertHospital(HashMap<String, Object> params) {
		return hospitalDao.insertHospital(params);
	}
	
	public ArrayList selectHospitalPage(HashMap<String, Object> params) {
		return hospitalDao.selectHospitalPage(params);
	}
	
	public int countHospitalApi(HashMap<String, Object> params) {
		return hospitalDao.countHospitalApi(params);
	}
	
	//Traffic
	public int deleteHospitalTraffic() {
		return hospitalDao.deleteHospitalTraffic();
	}
	
	public ArrayList selectEmergencySearch(HashMap<String, Object> params) {
		return hospitalDao.selectEmergencySearch(params);
	}
	
}
