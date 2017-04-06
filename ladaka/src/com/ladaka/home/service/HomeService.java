package com.ladaka.home.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladaka.home.dao.HomeDao;

@Service
public class HomeService {

	@Autowired
	HomeDao homeDao;
	
	public ArrayList<HashMap<String, Object>> businessUser(HashMap<String, Object> params) {
		return (ArrayList) homeDao.selectBusinessUser(params);
	}
	
	public ArrayList<HashMap<String, Object>> normalUser(HashMap<String, Object> params) {
		return (ArrayList) homeDao.selectNormalUser(params);
	}

}
