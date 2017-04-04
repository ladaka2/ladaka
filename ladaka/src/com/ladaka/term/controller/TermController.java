package com.ladaka.term.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ladaka.term.service.TermService;

@Controller
public class TermController {

	@Autowired
	private TermService termService;

	protected static Logger logger = Logger.getLogger(TermController.class.getName()); // 로그
	ModelAndView mav = null; // 모델
	HashMap<String, Object> params = null; // 파라메터

	/**
	 * <pre>
	 * 1. 개요: term1
	 * 2. 처리내용: 약관내용1 출력
	 * </pre>
	 */
	@RequestMapping(value = "/term1")
	public ModelAndView term1(HttpServletRequest req, HttpServletResponse res) {
		logger.debug("LoginController > term1");

		// 모델 설정
		mav = new ModelAndView();
		mav.setViewName("term/term1");

		return mav;
	}
}
