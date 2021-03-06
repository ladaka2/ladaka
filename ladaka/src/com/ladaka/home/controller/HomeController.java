package com.ladaka.home.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

		// 세션 GET
		HttpSession session = req.getSession();
		String email = (String)session.getAttribute("email");
		String registNum = (String)session.getAttribute("registNum");
		
		String loginType = null;
		
		// 결과값
		ArrayList<HashMap<String, Object>> result = null;

		// 파라메터 설정
		params = new HashMap<String, Object>();
		params.put("email", email); // 일반회원
		params.put("registNum", registNum); // 병원회원
		System.out.println("goHome params : " + params.toString());

		if (email == null && registNum == null) { // 미로그인
			loginType = "non";
			req.setAttribute("loginType", loginType);
		} else if(email != null && registNum == null) { // 일반로그인
			mav = new ModelAndView();
			mav.setViewName("home/home");
			result = homeService.normalUser(params);
			System.out.println("normalUser result : " + result); // 일반로그인 닉네임 출력
			mav.addObject("result", result);

			loginType = "normal";
			req.setAttribute("loginType", loginType);
			req.setAttribute("email", email);
			
			return mav;
		} else { // 그외 사업자 로그인
			mav = new ModelAndView();
			mav.setViewName("home/home");
			result = homeService.businessUser(params);
			System.out.println("businessUser result : " + result); // 사업자인경우 병원명칭 출력
			mav.addObject("result", result);
			
			loginType = "business";
			req.setAttribute("loginType", loginType);
			req.setAttribute("registNum", registNum);
			
			return mav;
		}
		
		// 모델 설정
		mav = new ModelAndView();
		mav.setViewName("home/home");

		return mav;
	}
	
	/**
	 * <pre>
	 * 1. 개요: userInfo
	 * 2. 처리내용: 로그인 정보 AJAX
	 * </pre>
	 */
	@RequestMapping(value = "/userInfo", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView userInfo(HttpServletRequest req, HttpServletResponse res) {
		logger.debug("HomeController > userInfo");

		// 세션 GET
		HttpSession session = req.getSession();
		String email = (String)session.getAttribute("email");
		String registNum = (String)session.getAttribute("registNum");
		
		//모델 설정
		mav = new ModelAndView();
		mav.setViewName("jsonView");

		//결과값
		ArrayList<HashMap<String, Object>> result = null;

		// 파라메터 설정
		params = new HashMap<String, Object>();
		params.put("email", email); // 일반회원
		params.put("registNum", registNum); // 병원회원
		System.out.println("userLogin params : " + params.toString());

		if (email != null) {
			result = homeService.normalUser(params); // DB Select
		} else {
			//result = homeService.hosUser(params); // DB Select
			result = homeService.businessUser(params); // DB Select
		}
		
		mav.addObject("userinfo", result);
		return mav;
	}
	
	/**
	 * <pre>
	 * 1. 개요: searchKeyword
	 * 2. 처리내용: 키워드검색 AJAX
	 * </pre>
	 */
	@RequestMapping(value = "/searchKeyword", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView searchKeyword(HttpServletRequest req, HttpServletResponse res) {
		logger.debug("HomeController > searchKeyword");
		
		// 입력값
		String keyword = req.getParameter("keyword");

		//모델 설정
		mav = new ModelAndView();
		mav.setViewName("jsonView");
		
		//결과값
		ArrayList<HashMap<String, Object>> result = null;
		
		// 파라메터 설정
		params = new HashMap<String, Object>();
		params.put("keyword", keyword); // 일반회원
		System.out.println("searchKeyword params : " + params.toString());
		
		if (keyword == null) {
			return null;
		} else {
			result = homeService.searchKeyword(params); // DB Select
		}
		
		mav.addObject("searchKeyword", result);
		return mav;
	}
	
}
