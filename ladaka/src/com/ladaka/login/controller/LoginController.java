package com.ladaka.login.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
		result = loginService.login(params);

		// 확인
		logger.debug(result.toString());

		return mav;
	} // end login

	@RequestMapping(value = "/userLogin")
	public void userLogin(HttpServletRequest req, HttpServletResponse res) {
		logger.debug("LoginController > userLogin");

		// 결과값
		ArrayList<HashMap<String, Object>> result = null;

		// 서비스 호출
		result = loginService.userLogin(params);

		// 확인
		logger.debug("userLogin : " + result.toString());

		// String --> Json 변환
		JSONArray loginArray = null;
		try {
			loginArray = new JSONArray(result);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		JSONObject obj = null;
		for (int i = 0; i < loginArray.length(); i++) {
			obj = loginArray.getJSONObject(i);
		}
		logger.debug("userLoginObject : " + obj);

	}

}
