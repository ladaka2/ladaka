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

	public int insertUserLogin(HashMap<String, Object> params) {
		return userDao.insertUserLogin(params);
	}

}
