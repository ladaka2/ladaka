package com.ladaka.api.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ladaka.api.service.ApiService;

@Controller
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	
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
		String result = null;
		
		//파라메터 설정
		params = new HashMap<String, Object>();
		
		//모델 설정
		mav = new ModelAndView();
		mav.setViewName("test/test");
		
		//서비스 호출
		//result = testService.test(params);
		
		//API 호출
		try {
			String serviceKey = "vZNjcCd88Bf%2BSJspiaA%2FfXS6JhvSRPK7yfYknuja0T1KYDickPWAElWdJlIhpkvF8H1hNKLVAVjomuREV%2B0Agw%3D%3D"; //인증키
			
			StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList"); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+serviceKey); /*서비스키 */
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
			
			//pageNo numOfRows
			
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if(responseCode==200) { //정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { //에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			System.out.println(response.toString());
			result = response.toString();
			
			JSONObject soapDatainJsonObject = XML.toJSONObject(result);
			result = soapDatainJsonObject.toString();
			System.out.println(result.toString());
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		//확인
		//logger.debug(result.toString());
		
		return result;
	}//end ApiGet
	
	
	@RequestMapping(value = "/apiGetToDB")
	public ModelAndView ApiGetToDB(HttpServletRequest req, HttpServletResponse res) {
		
		//결과값
		//ArrayList<HashMap<String, Object>> result = null;
		JSONObject result = null;
		
		//파라메터 설정
		params = new HashMap<String, Object>();
		params.put("pageNo", 1);
		params.put("numOfRows", 10);
		
		
		//모델 설정
		mav = new ModelAndView();
		mav.setViewName("api/api");
		
		//API 호출
		result = apiService.apiGet(params);
		System.out.println("[ApiGetToDB]"+result);//tot 68846
		
		//DB Insert
		apiService.insertJsonHospital(result);
		
		return mav;
	}
	
}
