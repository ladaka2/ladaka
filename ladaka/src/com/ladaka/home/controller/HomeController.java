package com.ladaka.home.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ladaka.home.service.HomeService;

@Controller
public class HomeController {

	@Autowired
	private HomeService homeService;

	protected static Logger logger = Logger.getLogger(HomeController.class.getName()); // 로그
	ModelAndView mav = null; // 모델
	HashMap<String, Object> params = null; // 파라메터

	/**
	 * <pre>
	 * 1. 개요: goHome
	 * 2. 처리내용: 홈화면 출력
	 * </pre>
	 */
	@RequestMapping(value = "/home")
	public ModelAndView goHome(HttpServletRequest req, HttpServletResponse res) {
		logger.debug("HomeController > goHome");

		// 결과값
		ArrayList<HashMap<String, Object>> result = null;

		// 파라메터 설정
		params = new HashMap<String, Object>();

		// 모델 설정
		mav = new ModelAndView();
		mav.setViewName("home/home");

		return mav;
	}

}