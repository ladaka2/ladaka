package com.ladaka.hospital.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.ladaka.hospital.dao.HospitalDao;

@Service
public class HospitalService {
	
	HospitalDao hospitalDao;
	
	public int insertHospital(HashMap<String, Object> params) {
		return hospitalDao.insertHospital(params);
	}
	
	
	
}
