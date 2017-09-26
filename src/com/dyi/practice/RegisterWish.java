package com.dyi.practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.http.client.ClientProtocolException;

import com.dyi.string.StringHelper;
import com.dyi.utils.HttpHelperWithCookie;

public class RegisterWish {
	static List<String> regList = new ArrayList<String>();

	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		for (int i = 0; i < 100; i++)
			new Thread(new Runnable() {
				public void run() {
					while (true) {

						String fName = StringHelper.getRandomName(6);
						String lName = StringHelper.getRandomName(6);
						String email = StringHelper.getRandomNum(11)
								+ "@qq.com";
						String pwd = "123456";
						String regInfo = String.format("{%s},{%s},{%s},{%s}",
								fName, lName, email, pwd);
						try {
							if (register(fName, lName, email, pwd)) {
								//System.out.println(regInfo);
								regList.add(regInfo);
								System.out.println(regList.size());
							} else {
								System.out.println("注册失败" + regInfo);
							}
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}).start();

	}

	public static boolean register(String firstName, String lastName,
			String email, String pwd) throws ClientProtocolException,
			IOException {
		HttpHelperWithCookie http = new HttpHelperWithCookie();
		String url = "https://www.wish.com/";
		/* 第一次请求，获取token */
		String result = http.get(url);
		String xsrf = http.getCookie("_xsrf");

		url = "https://www.wish.com/api/email-signup";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("first_name", firstName);
		map.put("last_name", lastName);
		map.put("email", email);
		map.put("password", pwd);
		Map<String, String> headMap = new HashMap<String, String>();
		headMap.put("X-XSRFToken", xsrf);

		result = http.post(url, map, headMap);

		
		if (result.contains("new") ) {
			System.out.println("注册成功**************************************************************");
			return true;
		}
		System.out.println(result);
		
		return false;

	}
}
