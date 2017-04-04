package com.ladaka.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladaka.home.dao.HomeDao;

@Service
public class HomeService {

	@Autowired
	HomeDao homeDao;
}
