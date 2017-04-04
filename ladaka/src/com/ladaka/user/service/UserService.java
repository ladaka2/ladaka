package com.ladaka.user.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladaka.user.dao.UserDao;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public ArrayList<HashMap<String, Object>> userLogin(HashMap<String, Object> params) {
		return (ArrayList) userDao.selectUserLogin(params);
	}

	public int insertUserLogin(HashMap<String, Object> params) {
		return userDao.insertUserLogin(params);
	}

	public ArrayList userLogin2(HashMap<String, Object> params) {
		return (ArrayList) userDao.selectUserLogin2(params);
	}
}
