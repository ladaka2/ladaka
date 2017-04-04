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

}
