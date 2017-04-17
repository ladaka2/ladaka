package com.ladaka.pharm.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladaka.pharm.dao.PharmDao;

@Service
public class PharmService {

	@Autowired
	PharmDao pharmDao;
	
	public ArrayList selectPharmPage(HashMap<String, Object> params) {
		return pharmDao.selectPharmPage(params);
	}
	
}
