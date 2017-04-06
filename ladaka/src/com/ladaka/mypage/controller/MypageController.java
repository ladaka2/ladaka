package com.ladaka.mypage.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ladaka.mypage.service.MypageService;

@Controller
public class MypageController {

	@Autowired
	private MypageService mypageService;

	protected static Logger logger = Logger.getLogger(MypageController.class.getName()); // 로그
	ModelAndView mav = null; // 모델
	HashMap<String, Object> params = null; // 파라메터

	/**
	 * <pre>
	 * 1. 개요: mypage
	 * 2. 처리내용: 마이페이지 출력
	 * </pre>
	 */
	@RequestMapping(value = "/mypage")
	public ModelAndView mypage(HttpServletRequest req, HttpServletResponse res) {
		logger.debug("LoginController > mypage");
		
		// 세션 GET
		HttpSession session = req.getSession();
		String email = (String)session.getAttribute("email");
		String registNum = (String)session.getAttribute("registNum");
				
		String loginType = null;

		// 결과값
		ArrayList result = null;

		// 파라메터 설정
		params = new HashMap<String, Object>();
		params.put("email", email); // 일반회원
		params.put("registNum", registNum); // 병원회원
		System.out.println("mypage params : " + params.toString());

		if (email == null && registNum == null) { // 미로그인
			loginType = "non";
			req.setAttribute("loginType", loginType);
		} else if(email != null && registNum == null) { // 일반로그인
			loginType = "normal";
			req.setAttribute("loginType", loginType);
			result = mypageService.normalUser(params); // DB Select
		} else { // 그외 사업자 로그인
			loginType = "business";
			req.setAttribute("loginType", loginType);
			req.setAttribute("registNum", registNum);
			
			/*mav = new ModelAndView();
			mav.setViewName("jsonView");
			
			result = mypageService.businessUser(params); // DB Select
			System.out.println("result : " + result);
			
			mav.addObject("result", result);*/
		}
		
		// 모델 설정
		mav = new ModelAndView();
		mav.setViewName("mypage/mypage");

		return mav;
	}
}
