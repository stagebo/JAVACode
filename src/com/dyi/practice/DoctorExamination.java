package com.dyi.practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.ParseException;
import org.apache.http.message.BasicNameValuePair;

import com.dyi.utils.EncriptHelper;
import com.dyi.utils.HttpHelper;

public class DoctorExamination {
	public static void main(String[] args) throws ParseException, IOException {
		String url;
		String username = "";
		String pwd = "391122";

		username = "";
		pwd = "391122";// 391122
		HttpHelper h = new HttpHelper();
		url = "http://api.yiboshi.com/api/study/student/login";
		List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
		pairList.add(new BasicNameValuePair("username", username));
		pairList.add(new BasicNameValuePair("password", EncriptHelper
				.GetMD5Code(pwd)));
		Map studentInfo = JSONObject.fromObject(JSONObject.fromObject(
				JSONObject.fromObject(h.sendPost(url, pairList)).get("data"))
				.get("studentInfo"));
		for (Object key : studentInfo.keySet()) {
			System.out.println(key + " : " + studentInfo.get(key.toString()));
		}
		String userid = studentInfo.get("id").toString();

		url = "http://api.yiboshi.com/api/study/student/listStudentProjCourseInfoAndStatus?userId=51424&trainingId=363&courseState=&compulsory=&keyword=";
		String courseList = h.sendGet(url);
		JSONObject json = JSONObject.fromObject(courseList);
		Map map = json;
		map = JSONObject.fromObject(map.get("data"));

		JSONArray jsonArray = JSONArray.fromObject(map.get("list"));
		List<String> list2 = (List) JSONArray.toCollection(jsonArray);
		// 成功数量和失败数量
		int count = 0;
		List<String> errList = new ArrayList<String>();
		for (Object info : list2) {

			Map listmap = JSONObject.fromObject(info);
			Object projectID = listmap.get("id");
			List<String> list3 = (List) JSONArray
					.toCollection((JSONArray) listmap.get("courseList"));
			for (Object course : list3) {
				Map coursemap = JSONObject.fromObject(course);
				Object id = coursemap.get("id");
				url = "http://api.yiboshi.com/api/WebApp/commitCoursePracticeScore?"
						+ "trainingId=363"
						+ "&projectId="
						+ projectID
						+ "&userId="
						+ userid
						+ "&courseId="
						+ id.toString()
						+ "&score=100" + "&versionId=3.1";
				String result = h.sendGet(url);
				System.out.println(result);
				Map resultMap = JSONObject.fromObject(result);
				System.out.println(resultMap.get("result"));
				if ("1".equals(resultMap.get("result").toString())) {
					count++;
				} else {
					errList.add(id.toString());
				}

			}
		}
		System.out.println("成功" + count);
		if (errList.size() == 0) {
			System.out.println("全部成功！");
		} else {
			System.out.println("一下课程失败！");
			for (String failID : errList) {
				System.out.println(failID);
			}
		}
	}
}
