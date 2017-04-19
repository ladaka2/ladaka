package com.ladaka.hospital.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ladaka.api.controller.ApiController;
import com.ladaka.hospital.service.HospitalService;

@Controller
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	
	protected static Logger logger = Logger.getLogger(ApiController.class.getName()); // 로그
	ModelAndView mav = null;//모델
	HashMap<String, Object> params = new HashMap<String, Object>(); // 파라메터
	
	@RequestMapping(value = "/hospitalSearch")
	public ModelAndView hospitalSearch(HttpServletRequest req, HttpServletResponse res) {
		
		// 모델 설정
		mav = new ModelAndView();
		mav.setViewName("hospital/hospitalSearch");
		
		return mav;
	}
	
	@RequestMapping(value = "/hospitalSearchBak")
	public ModelAndView hospitalSearchBak(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("hospitalSearchBak");
		
		// 모델 설정
		mav = new ModelAndView();
		mav.setViewName("hospital/hospitalSearchBak");
		
		return mav;
		
	}
	
	@RequestMapping(value = "/hospitalSearchAjax")
	@ResponseBody
	public ModelAndView hospitalSearchAjax(HttpServletRequest req, HttpServletResponse res) {
		
		// 결과값
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		
		// 입력값
		String latitude = req.getParameter("latitude");
		String longitude = req.getParameter("longitude");
		String dgsbjtCd = req.getParameter("dgsbjtCd");
		
		//Angular JS get Data
		/*
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			br = req.getReader();
			
			String str = null;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			JSONObject jObj = new JSONObject(sb.toString());
			latitude = jObj.getString("latitude");
			longitude = jObj.getString("longitude");
			
		} catch(Exception e) {
			
		}
		*/
		
		System.out.println(latitude+"/"+longitude);
		
		// 모델 설정
		mav = new ModelAndView();
		mav.setViewName("jsonView");
		
		//
		params.put("start", 0);
		params.put("page", 10);
		params.put("latitude", latitude);
		params.put("longitude", longitude);
		params.put("dgsbjtCd", dgsbjtCd);
		
		result = hospitalService.selectHospitalPage(params);
		
		mav.addObject("result", result);
		return mav;
	}

	@RequestMapping(value = "/emergencySearch")
	public ModelAndView emergencySearch(HttpServletRequest req, HttpServletResponse res) {
		
		//모델 설정
		mav = new ModelAndView();
		mav.setViewName("hospital/emergencySearch");
		
		return mav;
	}
	
	@RequestMapping(value = "/emergencySearchAjax")
	@ResponseBody
	public ModelAndView emergencySearchAjax(HttpServletRequest req, HttpServletResponse res) {
		
		// 결과값
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		
		// 입력값
		String latitude = req.getParameter("latitude");
		String longitude = req.getParameter("longitude");
		
		System.out.println(latitude+"/"+longitude);
		
		// 모델 설정
		mav = new ModelAndView();
		mav.setViewName("jsonView");
		
		params.put("start", 0);
		params.put("page", 10);
		params.put("latitude", latitude);
		params.put("longitude", longitude);
		
		result = hospitalService.selectEmergencySearch(params);
		
		mav.addObject("result", result);
		return mav;
	}

}
