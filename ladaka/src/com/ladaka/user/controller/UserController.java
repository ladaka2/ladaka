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
		params.put("EMAIL", email);
		params.put("NICKNAME", nickname);
		params.put("PSWORD", password);
		params.put("GENDER", gender);
		params.put("BORNYEAR", bornyear);
		System.out.println("userLogin params : " + params.toString());

		// 서비스 호출
		userService.insertUserLogin(params); // DB Insert

		mav.addObject("list", result);
		return mav;
	}
	
}
