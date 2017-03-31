package com.ladaka.util;

import java.util.HashMap;

public class CommonUtil {
	
	/**
	  * HashMap 에 해당 키값을 리턴 없을경우 ""을 리턴
	  * @param  str 대상 문자열
	  * @return trimed string with white space removed from the front.
	  */
	public static String HashMapEmptyNull(HashMap hashMap, String key) {
		if(hashMap.containsKey(key)) return hashMap.get(key).toString();
		else return "";
	}
	
}
