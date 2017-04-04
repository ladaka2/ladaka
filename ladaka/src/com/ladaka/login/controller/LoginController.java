package com.ladaka.login.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ladaka.login.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	protected static Logger logger = Logger.getLogger(LoginController.class.getName()); // 로그
	ModelAndView mav = null; // 모델
	HashMap<String, Object> params = null; // 파라메터

	/**
	 * <pre>
	 * 1. 개요: Login
	 * 2. 처리내용: 로그인화면 출력
	 * </pre>
	 */
	@RequestMapping(value = "/login")
	public ModelAndView Login(HttpServletRequest req, HttpServletResponse res) {
		logger.debug("LoginController > login");

		// 결과값
		ArrayList<HashMap<String, Object>> result = null;

		// 파라메터 설정
		params = new HashMap<String, Object>();

		// 모델 설정
		mav = new ModelAndView();
		mav.setViewName("login/login");

		// 서비스 호출
		// result = loginService.login(params);

		// 확인
		// logger.debug(result.toString());

		return mav;
	} // end login

	/**
	 * <pre>
	 * 1. 개요: findPw
	 * 2. 처리내용: 비밀번호찾기 화면 출력
	 * </pre>
	 */
	@RequestMapping(value = "/findPw")
	public ModelAndView findPw(HttpServletRequest req, HttpServletResponse res) {
		logger.debug("LoginController > findPw");

		// 결과값
		ArrayList<HashMap<String, Object>> result = null;

		// 파라메터 설정
		params = new HashMap<String, Object>();

		// 모델 설정
		mav = new ModelAndView();
		mav.setViewName("login/findPw");

		return mav;
	}

	/**
	 * <pre>
	 * 1. 개요: goRegist
	 * 2. 처리내용: 일반회원가입 화면 출력
	 * </pre>
	 */
	@RequestMapping(value = "/goRegist")
	public ModelAndView goRegist(HttpServletRequest req, HttpServletResponse res) {
		logger.debug("LoginController > goRegist");

		// 결과값
		ArrayList<HashMap<String, Object>> result = null;

		// 파라메터 설정
		params = new HashMap<String, Object>();

		// 모델 설정
		mav = new ModelAndView();
		mav.setViewName("login/goRegist");

		return mav;
	}

	/**
	 * <pre>
	 * 1. 개요: goRegist2
	 * 2. 처리내용: 병원외사업자회원가입 화면 출력
	 * </pre>
	 */
	@RequestMapping(value = "/goRegist2")
	public ModelAndView goRegist2(HttpServletRequest req, HttpServletResponse res) {
		logger.debug("LoginController > goRegist2");

		// 결과값
		ArrayList<HashMap<String, Object>> result = null;

		// 파라메터 설정
		params = new HashMap<String, Object>();

		// 모델 설정
		mav = new ModelAndView();
		mav.setViewName("login/goRegist2");

		return mav;
	}

}
