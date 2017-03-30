package com.ladaka.api.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladaka.api.dao.ApiDao;
import com.ladaka.hospital.dao.HospitalDao;

@Service
public class ApiService {
	
	@Autowired
	ApiDao apiDao;
	
	@Autowired
	HospitalDao hospitalDao;
	
	//병원정보서비스
	public JSONObject apiGet(HashMap<String, Object> params) {
		
		//결과값
		JSONObject result = null;
		
		//인증키
		String serviceKey = "vZNjcCd88Bf%2BSJspiaA%2FfXS6JhvSRPK7yfYknuja0T1KYDickPWAElWdJlIhpkvF8H1hNKLVAVjomuREV%2B0Agw%3D%3D";
		
		//URL
		String urlApi = "http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList";
		
		//입력값
		String pageNo = params.get("pageNo").toString();
		String numOfRows = params.get("numOfRows").toString();
		
		//API 호출
		try {
			StringBuilder urlBuilder = new StringBuilder(urlApi); //URL
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
			result = soapDatainJsonObject;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return result;
	}//end ApiGet
	
	
	//의료기관별상세정보서비스 http://apis.data.go.kr/B551182/medicInsttDetailInfoService/getTransportInfoList
	public JSONObject apiGetMedicDetailInfo(HashMap<String, Object> params) {
		//결과값
		JSONObject result = null;
		
		//인증키
		String serviceKey = "vZNjcCd88Bf%2BSJspiaA%2FfXS6JhvSRPK7yfYknuja0T1KYDickPWAElWdJlIhpkvF8H1hNKLVAVjomuREV%2B0Agw%3D%3D";
		
		//URL
		String urlApi = "http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList";
		
		//입력값
		String pageNo = params.get("pageNo").toString();
		String numOfRows = params.get("numOfRows").toString();
		
		//API 호출
		try {
			StringBuilder urlBuilder = new StringBuilder(urlApi); //URL
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
			result = soapDatainJsonObject;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return result;
	}
	
	//
	public int insertJsonHospital(JSONObject data) {
		
		System.out.println("ApiService > insertJsonHospital");
		JSONObject json;
		HashMap<String, Object> params = null;//파라메터
		
		json = (JSONObject)data.get("response");
		json = (JSONObject)json.get("body");
		json = (JSONObject)json.get("items");
		
		JSONArray array = json.getJSONArray("item");
		
		for(int i=0; i<array.length(); i++) {
			JSONObject obj = (JSONObject) array.get(i);
			params = new HashMap();
			params.put("ykiho", obj.get("ykiho") );
			params.put("yadmNm", obj.get("yadmNm") );
			params.put("addr", obj.get("addr") );
			if(obj.has("emdongNm")) params.put("emdongNm", obj.get("emdongNm"));
			if(obj.has("telno")) params.put("telno", obj.get("telno"));
			params.put("clCd", obj.get("clCd") );
			params.put("clCdNm", obj.get("clCdNm") );
			params.put("sidoCd", obj.get("sidoCd") );
			params.put("sidoCdNm", obj.get("sidoCdNm") );
			params.put("sgguCd", obj.get("sgguCd") );
			params.put("sgguCdNm", obj.get("sgguCdNm") );
			//params.put("emdongNm", obj.get("emdongNm") );
			params.put("postNo", obj.get("postNo") );
			if(obj.has("XPos")) params.put("XPos", obj.get("XPos")); else params.put("XPos", "0");
			if(obj.has("YPos")) params.put("YPos", obj.get("YPos")); else params.put("YPos", "0");
			
			hospitalDao.insertHospital(params);
			
		}
		
		return 1;
	}//end insertJsonHospital
	
}
