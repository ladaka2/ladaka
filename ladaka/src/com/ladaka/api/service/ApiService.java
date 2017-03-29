package com.ladaka.api.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

@Service
public class ApiService {
	
	public String ApiGet(HashMap<String, Object> params) {
		
		//결과값
		String result = null;
		
		//
		String serviceKey = "vZNjcCd88Bf%2BSJspiaA%2FfXS6JhvSRPK7yfYknuja0T1KYDickPWAElWdJlIhpkvF8H1hNKLVAVjomuREV%2B0Agw%3D%3D"; //인증키
		
		//입력값
		String pageNo = params.get("pageNo").toString();
		String numOfRows = params.get("numOfRows").toString();
		
		//API 호출
		try {
			StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList"); //URL
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "="+serviceKey); //서비스키
			urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); //페이지번호
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); //한 페이지 결과 수
			
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
			JSONObject soapDatainJsonObject = XML.toJSONObject(response.toString());
			result = soapDatainJsonObject.toString();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return result;
	}//end ApiGet
	
	//
	//public int Api
	
}
