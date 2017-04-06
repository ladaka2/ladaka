package com.ladaka.api.controller;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ladaka.api.service.ApiService;
import com.ladaka.hospital.service.HospitalService;

@Controller
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	
	@Autowired
	private HospitalService hospitalService;
	
	protected static Logger logger = Logger.getLogger(ApiController.class.getName());//로그
	ModelAndView mav = null;//모델
	HashMap<String, Object> params = null;//파라메터
	
	@RequestMapping(value = "/api")
	public ModelAndView Api(HttpServletRequest req, HttpServletResponse res) {
		
		//모델 설정
		mav = new ModelAndView();
		mav.setViewName("api/api");
		
		return mav;
	}
	
	@RequestMapping(value="/apiGet", produces="application/text; charset=utf8")
	@ResponseBody
	public String ApiGet(HttpServletRequest req, HttpServletResponse res) {
		logger.debug("TestController > test");
		
		//결과값
		//ArrayList<HashMap<String, Object>> result = null;
		//String result = null;
		JSONObject jsonObj = null;
		
		//파라메터 설정
		params = new HashMap<String, Object>();
		params.put("numOfRows", 10);
		params.put("pageNo", 1);
		params.put("apiType", "hosp");
		
		//모델 설정
		mav = new ModelAndView();
		mav.setViewName("test/test");
		
		//서비스 호출
		jsonObj = apiService.apiGet(params);
		
		return jsonObj.toString();
	}//end ApiGet
	
	
	//병원 초기데이터 구축용. 임의 사용금지.
	@RequestMapping(value = "/apiGetToDB")
	public ModelAndView ApiGetToDB(HttpServletRequest req, HttpServletResponse res) {
		
		//결과값
		//ArrayList<HashMap<String, Object>> result = null;
		JSONObject result = null;
		
		//파라메터 설정
		params = new HashMap<String, Object>();
		params.put("numOfRows", 100);
		params.put("apiType", "hosp");
		
		/* 초기 데이터 구축용 */
		for(int i=1; i<=689; i++) {
			params.put("pageNo", i);
			
			//API 호출
			result = apiService.apiGet(params);
			System.out.println("[ApiGetToDB]"+result);//tot 68846 > 6885/10 > 689/100
			
			//DB Insert
			apiService.insertJsonHospital(result);
		}
		
		
		//모델 설정
		mav = new ModelAndView();
		mav.setViewName("api/api");
		
		return mav;
	}
	
	@RequestMapping(value = "/apiMedicDetail")
	public ModelAndView apiMedicDetail(HttpServletRequest req, HttpServletResponse res) {
		
		//모델 설정
		mav = new ModelAndView();
		mav.setViewName("api/apiMedicDetail");
		
		return mav;
	}
	
	@RequestMapping(value = "/apiGetMedicDetail")
	@ResponseBody
	public ModelAndView apiGetMedicDetail(HttpServletRequest req, HttpServletResponse res) {
		
		//모델 설정
		mav = new ModelAndView();
		mav.setViewName("jsonView");
		
		//결과값
		JSONObject result = null;
		
		//입력값
		String apiType = req.getParameter("apiType");
		
		//파라메터 설정
		params = new HashMap<String, Object>();
		params.put("numOfRows", 100);
		params.put("pageNo", 1);
		params.put("apiType", apiType);
		
		System.out.println(params.toString());
		
		result = apiService.apiGetMedicDetailInfo(params);
		
		System.out.println("[L122]"+result.toString());
		mav.addObject("result", result.toString());
		return mav;
		
	}//end apiGetMedicDetail
	
	
	//병원 상세 데이터 입력 초기데이터 구축
	@RequestMapping(value = "/apiGetToDBDetail")
	@ResponseBody
	public ModelAndView ApiGetToDBDetail(HttpServletRequest req, HttpServletResponse res) {
		
		//모델 설정
		mav = new ModelAndView();
		mav.setViewName("jsonView");
		
		//결과값
		String result = "false";
		int count = 0;
		
		//입력값
		String apiType = req.getParameter("apiType");
		
		//파라메터 설정
		params = new HashMap<String, Object>();
		params.put("numOfRows", 100);
		params.put("pageNo", 0);
		params.put("apiType", apiType);
		
		//서비스 호출
		/* 초기 데이터 구축용 */
		count = hospitalService.countHospitalApi(params);
		System.out.println("count:"+count);
		
		if(count <= 0) {
			result = "true";
			mav.addObject("result", result);
			return mav;
		}
		
		int loopNum = count / 10;
		System.out.println("loopNum:"+loopNum);
		if(loopNum > 500) loopNum = 500;
		System.out.println("loopNum:"+loopNum);
		
		/* */
		try {
			for(int i=0; i<=loopNum; i++) { //69227 / 10 = 6922
				params.put("start", i*10);
				params.put("page", 10);
				apiService.insertJsonHospitalDetail(params);
				TimeUnit.SECONDS.sleep(1);//delay
			}
		} catch(Exception e) {
			System.out.println(e);
			mav.addObject("result", result);
			return mav;
		}
		
		
		result = "true";
		mav.addObject("result", result);
		return mav;
		
	}//ApiGetToDBDetail
	
	
	//약국기본정보 생성. 임의 실행 금지.
	//http://apis.data.go.kr/B551182/pharmacyInfoService/
	@RequestMapping(value = "/apiGetToDBPharm")
	@ResponseBody
	public ModelAndView ApiGetToDBPharm(HttpServletRequest req, HttpServletResponse res) {
		
		//모델 설정
		mav = new ModelAndView();
		mav.setViewName("jsonView");
		
		//결과값
		JSONObject jsonObj = null;
		String result = "false";
		
		//파라메터 설정
		params = new HashMap<String, Object>();
		params.put("numOfRows", 100);
		params.put("apiType", "pharm");
		
		/* 초기 데이터 구축용 
		for(int i=1; i<=216; i++) {
			params.put("pageNo", i);
			
			//API 호출
			jsonObj = apiService.apiGet(params);
			System.out.println("[ApiGetToDBPharm]"+jsonObj);// tot 21560 > 2156/10 > 216/100
			//tot 68846 > 6885/10 > 689/100
			
			//DB Insert
			apiService.insertJsonPharm(jsonObj);
			
		}
		*/
		
		result = "true";
		mav.addObject("result", result);
		return mav;
	}
	
	
}
