package com.dyi.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

import com.dyi.utils.HttpHelperWithCookie;

public class HttpHelperWithCookieTest {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpHelperWithCookie http = new HttpHelperWithCookie();
		String url = "https://www.wish.com/";
		String result = http.get(url);
		String xsrf = http.getCookie("_xsrf");
		
		url = "https://www.wish.com/api/email-signup";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("first_name", "aaa");
		map.put("last_name", "bbb");
		map.put("email", "165201521@qq.com");
		map.put("password", "123456");
		Map<String,String> headMap = new HashMap<String,String>();
		headMap.put("X-XSRFToken", xsrf);
		
		result = http.post(url, map, headMap);
		System.out.println(result);
		
	}
}
