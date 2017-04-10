package com.ladaka.login.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladaka.login.dao.LoginDao;

@Service
public class LoginService {

	@Autowired
	LoginDao loginDao;

	public ArrayList<HashMap<String, Object>> login(HashMap<String, Object> params) {
		return (ArrayList) loginDao.selectUser(params);
	}

	public ArrayList<HashMap<String, Object>> userLogin(HashMap<String, Object> params) {
		return (ArrayList) loginDao.selectUserLogin(params);
	}

	public ArrayList userLogin2(HashMap<String, Object> params) {
		return (ArrayList) loginDao.selectUserLogin2(params);
	}
	
	public ArrayList userLogin3(HashMap<String, Object> params) {
		return (ArrayList) loginDao.selectUserLogin3(params);
	}
	
}
