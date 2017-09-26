package com.dyi.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.ParseException;

import com.dyi.utils.HttpHelper;

public class HttpTest {
	public static void main(String[] args) throws ParseException, IOException {
		HttpHelper http = new HttpHelper();
		// System.out.println(http.sendGet("https://www.wish.com/analytics/1519"));
		// https://www.wish.com/api/email-signup
		/*
		 * first_name:ddd last_name:fff email:14564121@qq.com password:123123
		 */

		String url = "https://www.wish.com/api/email-signup";
		Map<String, String> map = new HashMap<String, String>();
		map.put("first_name", "aaa");
		map.put("last_name", "bbb");
		map.put("email", "165201521@qq.com");
		map.put("password", "123456");
		Map<String, String> header = new HashMap<String, String>();
		header.put("Accept", "application/json, text/javascript, */*; q=0.01");
		header.put("Accept-Encoding", "gzip, deflate, br");
		header.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
		header.put("Connection", "keep-alive");
		header.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		header.put(" Cookie", "__utmt=1;");
		header.put(" Origin", "https://www.wish.com");
		header.put(" User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36(KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
		String result = http.sendPost(url, map, header);
		System.out.println("result:" + result);
	}

	// Accept:application/json, text/javascript, */*; q=0.01
	// Accept-Encoding:gzip, deflate, br
	// Accept-Language:zh-CN,zh;q=0.8,en;q=0.6
	// Connection:keep-alive
	// Content-Length:92
	// Content-Type:application/x-www-form-urlencoded; charset=UTF-8
	// Cookie:__utmt=1;
	// _xsrf=2|20db4224|0b4287ed122eefcefacb8fa9befc26b2|1506390801;
	// IR_PI=1505262512432.vbp6xsycx83a1;
	// IR_4953=1506390801550%7C0%7C1506390302681;
	// Hm_lvt_9d483e9e48ba1faa0dfceaf6333de846=1506390304;
	// Hm_lpvt_9d483e9e48ba1faa0dfceaf6333de846=1506390802;
	// __utma=96128154.1055508656.1505262514.1505799984.1506390301.6;
	// __utmb=96128154.16.10.1506390301; __utmc=96128154;
	// __utmz=96128154.1505262514.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none);
	// bsid=30a2008718c146b79c70e94a8a4d76b4;
	// sweeper_uuid=2e816b70d9d14e76ba1b4b075acb30ac
	// Host:www.wish.com
	// Origin:https://www.wish.com
	// Referer:https://www.wish.com/
	// User-Agent:Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36
	// (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36
	// X-Requested-With:XMLHttpRequest
	// X-XSRFToken:2|20db4224|0b4287ed122eefcefacb8fa9befc26b2|1506390801
}
