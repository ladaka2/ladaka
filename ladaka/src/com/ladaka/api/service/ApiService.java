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
import com.ladaka.pharm.dao.PharmDao;
import com.ladaka.util.CommonUtil;

@Service
public class ApiService {
	
	@Autowired
	ApiDao apiDao;
	
	@Autowired
	HospitalDao hospitalDao;
	
	@Autowired
	PharmDao pharmDao;
	
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
		String serviceKey = dataPortalKey;
		
		//입력값
		String pageNo = params.get("pageNo").toString();
		String numOfRows = params.get("numOfRows").toString();
		String apiType = params.get("apiType").toString();
		
		//URL : apiType 분기
		String urlApi = "http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList"; //병원정보(hosp)
		if(apiType.equals("hosp")) urlApi = "http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList"; //병원정보(hosp)
		else if(apiType.equals("pharm")) urlApi = "http://apis.data.go.kr/B551182/pharmacyInfoService/getParmacyBasisList"; //약국정보(pharm)
		
		//API 호출
		try {
			StringBuilder urlBuilder = new StringBuilder(urlApi); //URL
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "="+serviceKey); //서비스키
			urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); //페이지번호
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); //한 페이지 결과 수
			
			URL url = new URL(urlBuilder.toString());
			System.out.println(url.toString());
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
			params.put("insertId", "init_batch" );
			
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
		HashMap<String, Object> paramsTmp2 = null;//Hospital 처리여부 업데이트
		
		//서비스 호출
		hospitalList = hospitalDao.selectHospitalPageApi(params);
		
		String urlApi = "http://apis.data.go.kr/B551182/medicInsttDetailInfoService";//URL
		String pageNo = "1";
		String numOfRows = "100";
		String hostIdx = "";
		String ykiho = "";
		
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
			System.out.println("HOST_IDX:"+hashMap.get("HOST_IDX"));
			hostIdx =  hashMap.get("HOST_IDX").toString();
			ykiho = hashMap.get("YKIHO").toString();
			paramsTmp = new HashMap<String, Object>();
			paramsTmp.put("hostIdx", hostIdx);
			paramsTmp.put("ykiho", ykiho);
			paramsTmp.put("insertId", "init_batch");
			//
			paramsTmp2 = new HashMap<String, Object>();
			paramsTmp2.put("hostIdx", hostIdx);
			paramsTmp2.put("ykiho", ykiho);
			paramsTmp2.put("updateId", "init_batch");
			if(apiType.equals("transport")) {//교통정보
				paramsTmp2.put("trafficYn", "Y");
			} else if(apiType.equals("sbject")) {//진료과목
				paramsTmp2.put("subjectYn", "Y");
			} else if(apiType.equals("detail")) {//세부정보
				paramsTmp2.put("detailYn", "Y");
			}
			
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
				return "false";
			}
			
			//DB Insert
			JSONObject tmp = null;
			JSONArray tmpArray = null;
			int totalCount = 0;
			
			tmp = (JSONObject)jsonObject.get("response");
			
			if(apiType.equals("detail")) {//세부정보 별도 처리
				//System.out.println("[L289]"+tmp.toString());
				if(tmp.get("body").toString() == "") {
					System.out.println("없음");
				} else {
					tmp = (JSONObject)tmp.get("body");
					tmp = (JSONObject)tmp.get("item");
					
					paramsTmp.put("lunchWeek", CommonUtil.JsonObjectEmptyNull(tmp, "lunchWeek"));
					paramsTmp.put("noTrmtSun", CommonUtil.JsonObjectEmptyNull(tmp, "noTrmtSun"));
					paramsTmp.put("noTrmtHoli", CommonUtil.JsonObjectEmptyNull(tmp, "noTrmtHoli"));
					paramsTmp.put("emyDayYn", CommonUtil.JsonObjectEmptyNull(tmp, "emyDayYn"));
					paramsTmp.put("emyDayTelNo1", CommonUtil.JsonObjectEmptyNull(tmp, "emyDayTelNo1"));
					paramsTmp.put("emyDayTelNo2", CommonUtil.JsonObjectEmptyNull(tmp, "emyDayTelNo2"));
					paramsTmp.put("emyNgtYn", CommonUtil.JsonObjectEmptyNull(tmp, "emyNgtYn"));
					paramsTmp.put("emyNgtTelNo1", CommonUtil.JsonObjectEmptyNull(tmp, "emyNgtTelNo1"));
					paramsTmp.put("emyNgtTelNo2", CommonUtil.JsonObjectEmptyNull(tmp, "emyNgtTelNo2"));
					
					hospitalDao.inserthospitalDetail(paramsTmp);
				}
				hospitalDao.updateHospitalApi(paramsTmp2);
				continue;
			}//end if
			
			tmp = (JSONObject)tmp.get("body");
			
			totalCount = Integer.parseInt(tmp.get("totalCount").toString());
			if(totalCount == 0) ; //없을경우
			else if(totalCount == 1) {//1건
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
					paramsTmp.put("dgsbjtCd", CommonUtil.JsonObjectEmptyNull(tmp, "dgsbjtCd"));
					paramsTmp.put("dgsbjtCdNm", CommonUtil.JsonObjectEmptyNull(tmp, "dgsbjtCdNm"));
					
					hospitalDao.inserthospitalSubject(paramsTmp);
				}
				
			} else {//다건
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
						paramsTmp.put("dgsbjtCd", CommonUtil.JsonObjectEmptyNull(obj, "dgsbjtCd"));
						paramsTmp.put("dgsbjtCdNm", CommonUtil.JsonObjectEmptyNull(obj, "dgsbjtCdNm"));
						
						hospitalDao.inserthospitalSubject(paramsTmp);
					}
					
				}
				
			}
			
			//Hospital Check Update
			hospitalDao.updateHospitalApi(paramsTmp2);
			//System.out.println("[L342]"+tmp.toString());
		}//end for
		
		
		return result;
	}//end insertJsonHospitalDetail
	
	
	//
	public int insertJsonPharm(JSONObject data) {
		
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
			params.put("sidoCd", obj.get("sidoCd") );
			params.put("sidoCdNm", obj.get("sidoCdNm") );
			params.put("sgguCd", obj.get("sgguCd") );
			params.put("sgguCdNm", obj.get("sgguCdNm") );
			params.put("postNo", obj.get("postNo") );
			if(obj.has("XPos")) params.put("XPos", obj.get("XPos")); else params.put("XPos", "0");
			if(obj.has("YPos")) params.put("YPos", obj.get("YPos")); else params.put("YPos", "0");
			params.put("insertId", "init_batch" );
			
			pharmDao.insertPharm(params);
			//System.out.println(params.toString());
		}
		
		return 1;
	}//end insertJsonPharm
	
}
