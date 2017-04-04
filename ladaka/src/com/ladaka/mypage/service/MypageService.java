package com.ladaka.mypage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladaka.mypage.dao.MypageDao;

@Service
public class MypageService {

	@Autowired
	MypageDao mypageDao;
}
