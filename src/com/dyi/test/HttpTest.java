package com.dyi.test;

import java.io.IOException;

import org.apache.http.ParseException;

import com.dyi.utils.HttpHelper;

public class HttpTest {
	public static void main(String[] args) throws ParseException, IOException {
		HttpHelper http = new HttpHelper();
		System.out.println(http.sendGet("http://www.baidu.com"));
	}
}
