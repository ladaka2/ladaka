package com.ladaka.login.controller;

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

		// 세션 GET
		HttpSession session = req.getSession();
		
		// 세션 Clear
		session.removeAttribute("email");
		session.removeAttribute("registNum");
				
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
	 * 1. 개요: userLogin
	 * 2. 처리내용: 일반회원 로그인 AJAX
	 * </pre>
	 */
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView userLogin(HttpServletRequest req, HttpServletResponse res) {
		logger.debug("UserController > userLogin");

		String email = req.getParameter("emailImsi");
		String pwNum = req.getParameter("pwImsi");
		
		//모델 설정
		mav = new ModelAndView();
		mav.setViewName("jsonView");

		//결과값
		ArrayList result = null;

		//파라메터 설정
		params = new HashMap<String, Object>();
		params.put("email", email);
		params.put("psword", pwNum);
		System.out.println("userLogin params : " + params.toString());

		// 세션 SET
		HttpSession session = req.getSession();
		session.setAttribute("email", email);

		result = loginService.userLogin(params); // DB Select

		mav.addObject("list", result);
		return mav;
	}
	
	/**
	 * <pre>
	 * 1. 개요: userLogin2
	 * 2. 처리내용: 사업자회원 로그인 AJAX
	 * </pre>
	 */
	@RequestMapping(value = "/userLogin2", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView userLogin2(HttpServletRequest req, HttpServletResponse res) {
		logger.debug("UserController > userLogin2");
		
		String registNum = req.getParameter("registNumImsi");
		String pwNum = req.getParameter("pwImsi");
		
		//모델 설정
		mav = new ModelAndView();
		mav.setViewName("jsonView");

		//결과값
		ArrayList result = null;

		//파라메터 설정
		params = new HashMap<String, Object>();
		params.put("registNum", registNum);
		params.put("psword", pwNum);
		System.out.println("userLogin2 params : " + params.toString());
		
		// 세션 SET
		HttpSession session = req.getSession();
		session.setAttribute("registNum", registNum);

		result = loginService.userLogin2(params); // DB Select

		mav.addObject("list", result);
		return mav;
	}
	
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
