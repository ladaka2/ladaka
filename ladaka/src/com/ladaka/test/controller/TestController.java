package com.ladaka.test.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ladaka.test.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	private TestService testService;
	
	protected static Logger logger = Logger.getLogger(TestController.class.getName());//로그
	ModelAndView mav = null;//모델
	HashMap<String, Object> params = null;//파라메터
	
	@RequestMapping(value = "/test")
	public ModelAndView test(HttpServletRequest req, HttpServletResponse res) {
		logger.debug("TestController > test");
		
		//결과값
		ArrayList<HashMap<String, Object>> result = null;
		
		//파라메터 설정
		params = new HashMap<String, Object>();
		
		//모델 설정
		mav = new ModelAndView();
		mav.setViewName("test/test");
		
		//서비스 호출
		result = testService.test(params);
		
		//확인
		logger.debug(result.toString());
		
		return mav;
	}//end test
	
}
