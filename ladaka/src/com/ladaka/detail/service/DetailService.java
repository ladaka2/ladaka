package com.ladaka.detail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladaka.detail.dao.DetailDao;

@Service
public class DetailService {

	@Autowired
	DetailDao detailDao;

}
