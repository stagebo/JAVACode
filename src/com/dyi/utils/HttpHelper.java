package com.dyi.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpHelper {
	private CloseableHttpClient client;

	public HttpHelper() {
		this.client = HttpClients.createDefault();		
	}

	public String sendGet(String url) throws ParseException, IOException {
		String respContent = "";
		HttpGet httpPost = new HttpGet(url);
		
		HttpResponse resp = client.execute(httpPost);
		if (resp.getStatusLine().getStatusCode() == 200) {
			HttpEntity he = resp.getEntity();
			respContent = EntityUtils.toString(he, "UTF-8");
		}
		return respContent;
	}

	/**
	 * 
	 * @param url
	 * @param pairList
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public String sendPost(String url, List<BasicNameValuePair> pairList)
			throws ParseException, IOException {
		String respContent = "";
		HttpPost httpPost = new HttpPost(url);

		// 表单方式

		httpPost.setEntity(new UrlEncodedFormEntity(pairList, "utf-8"));

		HttpResponse resp = client.execute(httpPost);
		if (resp.getStatusLine().getStatusCode() == 200) {
			HttpEntity he = resp.getEntity();
			respContent = EntityUtils.toString(he, "UTF-8");
		}
		return respContent;
	}

	public String sendPost(String url, Map<String, String> paramMap)
			throws ParseException, IOException {
		String respContent = "";
		HttpPost httpPost = new HttpPost(url);

		// 表单方式
		if (paramMap != null) {

			List<BasicNameValuePair> paramList = new ArrayList<BasicNameValuePair>();
			for(String key:paramMap.keySet()){
				paramList.add(new BasicNameValuePair(key, paramMap.get(key)));
			}
			httpPost.setEntity(new UrlEncodedFormEntity(paramList, "utf-8"));
		}

		HttpResponse resp = client.execute(httpPost);
		if (resp.getStatusLine().getStatusCode() == 200) {
			HttpEntity he = resp.getEntity();
			respContent = EntityUtils.toString(he, "UTF-8");
		}
		return respContent;
	}
	
	public String sendPost(String url, Map<String, String> paramMap,Map<String,String> headerMap)
			throws ParseException, IOException {
		String respContent = "";
		HttpPost httpPost = new HttpPost(url);

		// 表单方式
		if (paramMap != null) {

			List<BasicNameValuePair> paramList = new ArrayList<BasicNameValuePair>();
			for(String key:paramMap.keySet()){
				paramList.add(new BasicNameValuePair(key, paramMap.get(key)));
			}
			httpPost.setEntity(new UrlEncodedFormEntity(paramList, "utf-8"));
		}
		//添加请求头
		if(headerMap != null){
			for(String key : headerMap.keySet()){
				httpPost.addHeader(key, headerMap.get(key));
			}			
		}
		HttpResponse resp = client.execute(httpPost);
		if (resp.getStatusLine().getStatusCode() == 200) {
			HttpEntity he = resp.getEntity();
			respContent = EntityUtils.toString(he, "UTF-8");
		}
		return respContent;
	}
}
