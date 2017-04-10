package com.ladaka.user.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ladaka.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	protected static Logger logger = Logger.getLogger(UserController.class.getName()); // 로그
	ModelAndView mav = null; // 모델
	HashMap<String, Object> params = null; // 파라미터

	/**
	 * <pre>
	 * 1. 개요: goRegistAjax
	 * 2. 처리내용: 일반회원가입 AJAX
	 * </pre>
	 */
	@RequestMapping(value = "/goRegistAjax")
	public ModelAndView goRegistAjax(HttpServletRequest req, HttpServletResponse res) {
		logger.debug("UserController > goRegistAjax");
		
		String email = req.getParameter("email");
		String nickname = req.getParameter("nickname");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String bornyear = req.getParameter("bornyear");

		//모델 설정
		mav = new ModelAndView();
		mav.setViewName("jsonView");

		//결과값
		String result = "false";

		//파라메터 설정
		params = new HashMap<String, Object>();
		params.put("email", email);
		params.put("nickname", nickname);
		params.put("psword", password);
		params.put("gender", gender);
		params.put("bornYear", bornyear);
		System.out.println("userLogin params : " + params.toString());

		// 서비스 호출
		userService.insertUserLogin(params); // DB Insert

		mav.addObject("list", result);
		return mav;
	}
	
	/**
	 * <pre>
	 * 1. 개요: goRegistAjax2
	 * 2. 처리내용: 병원 회원가입 AJAX
	 * </pre>
	 */
	@RequestMapping(value = "/goRegistAjax2")
	public ModelAndView goRegistAjax2(HttpServletRequest req, HttpServletResponse res) {
		logger.debug("UserController > goRegistAjax2");
		
		String businessName = req.getParameter("businessName");
		String businessNum = req.getParameter("businessNum");
		String registPic = req.getParameter("registPic");
		String password = req.getParameter("password");
		String managerName = req.getParameter("managerName");
		String managerNum = req.getParameter("managerNum");
		String email = req.getParameter("email");
		String hospitalKeyword = req.getParameter("hospitalKeyword");
		
		//모델 설정
		mav = new ModelAndView();
		mav.setViewName("jsonView");
		
		//결과값
		String result = "false";
		
		//파라메터 설정
		params = new HashMap<String, Object>();
		params.put("name", businessName);
		params.put("registNum", businessNum);
		params.put("registPic", registPic);
		params.put("psword", password);
		params.put("managerName", managerName);
		params.put("managerNum", managerNum);
		params.put("email", email);
		params.put("keyword", hospitalKeyword);
		System.out.println("userLogin2 params : " + params.toString());
		
		// 서비스 호출
		userService.insertUserLogin2(params); // DB Insert
		
		mav.addObject("list", result);
		return mav;
	}
	
	/**
	 * <pre>
	 * 1. 개요: goRegistAjax3
	 * 2. 처리내용: 사업자 회원가입 AJAX
	 * </pre>
	 */
	@RequestMapping(value = "/goRegistAjax3")
	public ModelAndView goRegistAjax3(HttpServletRequest req, HttpServletResponse res) {
		logger.debug("UserController > goRegistAjax3");
		
		String businessCate = req.getParameter("businessCate");
		String businessName = req.getParameter("businessName");
		String businessNum = req.getParameter("businessNum");
		String registPic = req.getParameter("registPic");
		String password = req.getParameter("password");
		String managerName = req.getParameter("managerName");
		String managerNum = req.getParameter("managerNum");
		String email = req.getParameter("email");
		String businessKeyword = req.getParameter("businessKeyword");
		
		//모델 설정
		mav = new ModelAndView();
		mav.setViewName("jsonView");
		
		//결과값
		String result = "false";
		
		//파라메터 설정
		params = new HashMap<String, Object>();
		params.put("category", businessCate);
		params.put("name", businessName);
		params.put("registNum", businessNum);
		params.put("registPic", registPic);
		params.put("psword", password);
		params.put("managerName", managerName);
		params.put("managerNum", managerNum);
		params.put("email", email);
		params.put("keyword", businessKeyword);
		System.out.println("goRegistAjax3 params : " + params.toString());
		
		// 서비스 호출
		userService.insertUserLogin3(params); // DB Insert
		
		mav.addObject("list", result);
		return mav;
	}
	
}
