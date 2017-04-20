package com.ladaka.detail.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ladaka.api.controller.ApiController;
import com.ladaka.detail.service.DetailService;

@Controller
public class DetailController {

	@Autowired
	private DetailService detailService;
	
	protected static Logger logger = Logger.getLogger(ApiController.class.getName()); // 로그
	ModelAndView mav = null; // 모델
	HashMap<String, Object> params = new HashMap<String, Object>(); // 파라메터

	@RequestMapping(value = "/searchList")
	public ModelAndView searchList(HttpServletRequest req, HttpServletResponse res) {
		
		// 모델 설정
		mav = new ModelAndView();
		mav.setViewName("detail/searchList");
		
		return mav;
	}

}
