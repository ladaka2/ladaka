package com.ladaka.pharm.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ladaka.api.controller.ApiController;
import com.ladaka.pharm.service.PharmService;

@Controller
public class PharmController {
	
	@Autowired
	private PharmService pharmService;
	
	protected static Logger logger = Logger.getLogger(ApiController.class.getName()); // 로그
	ModelAndView mav = null; // 모델
	HashMap<String, Object> params = new HashMap<String, Object>(); // 파라메터
	
	@RequestMapping(value = "/pharmSearch")
	public ModelAndView pharmSearch(HttpServletRequest req, HttpServletResponse res) {
		
		// 모델 설정
		mav = new ModelAndView();
		mav.setViewName("pharm/pharmSearch");
		
		return mav;
		
	}
	
	@RequestMapping(value = "/pharmSearchAjax")
	@ResponseBody
	public ModelAndView pharmSearchAjax(HttpServletRequest req, HttpServletResponse res) {
		
		// 결과값
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		
		// 입력값
		String latitude = req.getParameter("latitude");
		String longitude = req.getParameter("longitude");
		
		System.out.println(latitude+"/"+longitude);
		
		// 모델 설정
		mav = new ModelAndView();
		mav.setViewName("jsonView");
		
		params.put("start", 0);
		params.put("page", 10);
		params.put("latitude", latitude);
		params.put("longitude", longitude);
		
		result = pharmService.selectPharmPage(params);
		
		mav.addObject("result", result);
		System.out.println("result : " + result);
		return mav;
	}

}
