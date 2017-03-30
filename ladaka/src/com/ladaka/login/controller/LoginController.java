package com.ladaka.login.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
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
		//result = loginService.login(params);

		// 확인
		//logger.debug(result.toString());

		return mav;
	} // end login

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	@ResponseBody
	public String userLogin(HttpServletRequest req, HttpServletResponse res) {
		logger.debug("LoginController > userLogin");

		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		result = loginService.userLogin(params);
		logger.debug("userLoginArrayList : " + result);

		JSONObject obj = new JSONObject();

		try {
			JSONArray jArray = new JSONArray(); // 배열이 필요할때

			for (int i = 0; i < result.size(); i++) {
				JSONObject sObject = new JSONObject(); // 배열 내에 들어갈 json
				sObject.put("item", result.get(i));
				jArray.put(sObject);
			}

			obj.put("list", jArray); // 배열을 넣음
			logger.debug("userLoginJsonArray : " + obj.toString());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return obj.toString();
	}

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
