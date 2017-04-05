package com.ladaka.mypage.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladaka.mypage.dao.MypageDao;

@Service
public class MypageService {

	@Autowired
	MypageDao mypageDao;
	
	public ArrayList<HashMap<String, Object>> normalUser(HashMap<String, Object> params) {
		return (ArrayList) mypageDao.selectNormalUser(params);
	}

	public ArrayList<HashMap<String, Object>> businessUser(HashMap<String, Object> params) {
		return (ArrayList) mypageDao.selectBusinessUser(params);
	}
}
