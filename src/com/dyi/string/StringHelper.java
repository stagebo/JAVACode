package com.dyi.string;

import java.util.Random;

public class StringHelper {
	public static String getRandomName(int length){
		String str = "abcdefghijklmnopqrstuvwxyz";
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<length;i++){
			int aim = r.nextInt(str.length());
			sb.append(str.charAt(aim));
		}
		return sb.toString();
	}
	public static String getRandomNum(int length){
		String str = "0123456789";
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<length;i++){
			int aim = r.nextInt(str.length());
			sb.append(str.charAt(aim));
		}
		return sb.toString();
	}
}
