package com.ladaka.util;

import java.util.HashMap;

import org.json.JSONObject;

public class CommonUtil {
	
	/**
	  * HashMap 에 해당 키값을 리턴 없을경우 ""을 리턴
	  * @param  str 대상 문자열
	  * @return 
	  */
	public static String HashMapEmptyNull(HashMap hashMap, String key) {
		if(hashMap.containsKey(key)) return hashMap.get(key).toString();
		else return "";
	}
	
	/**
	  * JsonObject 에 해당 키값을 리턴 없을경우 ""을 리턴
	  * @param  str 대상 문자열
	  * @return 
	  */
	public static String JsonObjectEmptyNull(JSONObject jonsObject, String key) {
		if(jonsObject.has(key)) {
			String tmp = jonsObject.get(key).toString().trim();
			tmp = tmp.replace("'", "");
			return tmp;
		} else return "";
	}
	
	
}
