package com.ladaka.api.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ladaka.api.dao.ApiDao;
import com.ladaka.hospital.dao.HospitalDao;
import com.ladaka.util.CommonUtil;

@Service
public class ApiService {
	
	@Autowired
	ApiDao apiDao;
	
	@Autowired
	HospitalDao hospitalDao;
	
	CommonUtil commonUtil;
	
	Properties properties = new Properties();
	
	// 프로퍼티 파일 읽기
	@Value("${common.public.dataPortalKey}")
	private String dataPortalKey;
	
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
	
	
	//의료기관별 상세 정보서비스
	//(교통정보) http://apis.data.go.kr/B551182/medicInsttDetailInfoService/getTransportInfoList
	//(진료과목) http://apis.data.go.kr/B551182/medicInsttDetailInfoService/getMdlrtSbjectInfoList
	//(세부정보) http://apis.data.go.kr/B551182/medicInsttDetailInfoService/getDetailInfo
	public JSONObject apiGetMedicDetailInfo(HashMap<String, Object> params) {
		//결과값
		JSONObject result = null;
		
		//인증키
		String serviceKey = "vZNjcCd88Bf%2BSJspiaA%2FfXS6JhvSRPK7yfYknuja0T1KYDickPWAElWdJlIhpkvF8H1hNKLVAVjomuREV%2B0Agw%3D%3D";
		
		
		
		
		//입력값
		String pageNo = commonUtil.HashMapEmptyNull(params, "pageNo");
		String numOfRows = commonUtil.HashMapEmptyNull(params, "numOfRows");
		String apiType = commonUtil.HashMapEmptyNull(params, "apiType");
		
		//URL
		String urlApi = "http://apis.data.go.kr/B551182/medicInsttDetailInfoService/getDetailInfo";
		
		//
		params.put("start", 1);
		params.put("page", 10);
		ArrayList hospitalList = hospitalDao.selectHospitalPage(params);
		
		
		//API 호출
		try {
			StringBuilder urlBuilder = new StringBuilder(urlApi); //URL
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "="+serviceKey); //서비스키
			urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); //페이지번호
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); //한 페이지 결과 수
			urlBuilder.append("&" + URLEncoder.encode("ykiho", "UTF-8") + "=" + URLEncoder.encode("JDQ4MTg4MSM1MSMkMSMkMCMkODkkMzgxMzUxIzExIyQyIyQ3IyQwMCQyNjEyMjIjNjEjJDEjJDgjJDgz", "UTF-8"));
			
			URL url = new URL(urlBuilder.toString());
			System.out.println("URL:"+url);
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
			params = new HashMap<String, Object>();
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
			params.put("postNo", obj.get("postNo") );
			if(obj.has("XPos")) params.put("XPos", obj.get("XPos")); else params.put("XPos", "0");
			if(obj.has("YPos")) params.put("YPos", obj.get("YPos")); else params.put("YPos", "0");
			
			hospitalDao.insertHospital(params);
			
		}
		
		return 1;
	}//end insertJsonHospital
	
	
	//
	public String insertJsonHospitalDetail(HashMap<String, Object> params) {
		
		//결과값
		String result = "true";
		ArrayList hospitalList = new ArrayList();
		JSONObject jsonObject = null;
		
		//입력값
		String apiType = commonUtil.HashMapEmptyNull(params, "apiType");
		String serviceKey = dataPortalKey; //인증키
		HashMap<String, Object> paramsTmp = null;
		
		//서비스 호출
		//params.put("start", 0);
		//params.put("page", 10);
		hospitalList = hospitalDao.selectHospitalPage(params);
		
		String urlApi = "http://apis.data.go.kr/B551182/medicInsttDetailInfoService";//URL
		String pageNo = "1";
		String numOfRows = "100";
		String hostIdx = "";
		String ykiho = "JDQ4MTg4MSM1MSMkMSMkMCMkODkkMzgxMzUxIzExIyQyIyQ3IyQwMCQyNjEyMjIjNjEjJDEjJDgjJDgz";
		
		if(apiType.equals("transport")) {//교통정보
			urlApi += "/getTransportInfoList";
		} else if(apiType.equals("sbject")) {//진료과목
			urlApi += "/getMdlrtSbjectInfoList";
		} else if(apiType.equals("detail")) {//세부정보
			urlApi += "/getDetailInfo";
		} else {
			return "false";
		}
		
		for(int i=0; i<hospitalList.size(); i++) {
			HashMap hashMap = (HashMap)hospitalList.get(i);
			System.out.println(hashMap.get("HOST_IDX"));
			System.out.println(hashMap.get("YKIHO"));
			hostIdx =  hashMap.get("HOST_IDX").toString();
			ykiho = hashMap.get("YKIHO").toString();
			paramsTmp = new HashMap<String, Object>();
			paramsTmp.put("hostIdx", hostIdx);
			paramsTmp.put("ykiho", ykiho);
			paramsTmp.put("insertId", "init_batch");
			
			//API 호출
			try {
				StringBuilder urlBuilder = new StringBuilder(urlApi); //URL
				urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "="+serviceKey); //서비스키
				urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); //페이지번호
				urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); //한 페이지 결과 수
				urlBuilder.append("&" + URLEncoder.encode("ykiho", "UTF-8") + "=" + URLEncoder.encode(ykiho, "UTF-8"));
				
				URL url = new URL(urlBuilder.toString());
				System.out.println("URL:"+url);
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
				jsonObject = XML.toJSONObject(response.toString());
				System.out.println(jsonObject.toString());
			} catch (Exception e) {
				System.out.println(e);
			}
			
			//DB Insert
			JSONObject tmp = null;
			JSONArray tmpArray = null;
			int totalCount = 0;
			
			tmp = (JSONObject)jsonObject.get("response");
			tmp = (JSONObject)tmp.get("body");
			
			totalCount = Integer.parseInt(tmp.get("totalCount").toString());
			if(totalCount == 0) continue; //없을경우
			else if(totalCount == 1) {
				tmp = (JSONObject)tmp.get("items");
				tmp = (JSONObject)tmp.get("item");
				
				if(apiType.equals("transport")) {//교통정보
					paramsTmp.put("trafNm", CommonUtil.JsonObjectEmptyNull(tmp, "trafNm"));
					paramsTmp.put("lineNo", CommonUtil.JsonObjectEmptyNull(tmp, "lineNo"));
					paramsTmp.put("arivPlc", CommonUtil.JsonObjectEmptyNull(tmp, "arivPlc"));
					paramsTmp.put("dir", CommonUtil.JsonObjectEmptyNull(tmp, "dir"));
					paramsTmp.put("dist", CommonUtil.JsonObjectEmptyNull(tmp, "dist"));
					
					hospitalDao.insertHospitalTraffic(paramsTmp);
				} else if(apiType.equals("sbject")) {//진료과목
					
				} else if(apiType.equals("detail")) {//세부정보
					
				}
				
			} else {
				tmp = (JSONObject)tmp.get("items");
				tmpArray = tmp.getJSONArray("item");
				
				for(int j=0; j<tmpArray.length(); j++) {
					JSONObject obj = (JSONObject) tmpArray.get(j);
					
					if(apiType.equals("transport")) {//교통정보
						paramsTmp.put("trafNm", CommonUtil.JsonObjectEmptyNull(obj, "trafNm"));
						paramsTmp.put("lineNo", CommonUtil.JsonObjectEmptyNull(obj, "lineNo"));
						paramsTmp.put("arivPlc", CommonUtil.JsonObjectEmptyNull(obj, "arivPlc"));
						paramsTmp.put("dir", CommonUtil.JsonObjectEmptyNull(obj, "dir"));
						paramsTmp.put("dist", CommonUtil.JsonObjectEmptyNull(obj, "dist"));
						
						hospitalDao.insertHospitalTraffic(paramsTmp);
					} else if(apiType.equals("sbject")) {//진료과목
						
					} else if(apiType.equals("detail")) {//세부정보
						
					}
					
				}
				
			}
			
			System.out.println(tmp.toString());
		}//end for
		
		
		return result;
	}//end insertJsonHospitalDetail
	
	
}
