package com.ladaka.base;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ladaka.common.dao.MyBatisDao;

@Service
public class BaseService {
	
	@Resource(name = "myBatisDao")
	protected MyBatisDao myBatisDao;
	
}
