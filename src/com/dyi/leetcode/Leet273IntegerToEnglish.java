package com.dyi.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert a non-negative integer to its english words representation. Given
 * input is guaranteed to be less than 231 - 1.
 * 
 * For example, 123 -> "One Hundred Twenty Three" 12345 ->
 * "Twelve Thousand Three Hundred Forty Five" 1234567 ->
 * "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 
 * @author WANYONGBO
 * 
 */
public class Leet273IntegerToEnglish {

	public static void main(String[] args) {
		for (int i = 1; i < 100000; i++) {
			System.out.println(IntegerToChinese(i));
		}
	}

	public static String IntegerToEnglish(int x) {
		// TODO as Integer To Chinese.
		return null;
	}

	public static String IntegerToChinese(int x) {
		if (x <= 0) {
			return "param should grate than 0.";
		}
		Map<Integer, String> map = new HashMap<Integer, String>();
		String[] unit = new String[] { "十", "亿", "千", "百", "十", "万", "千", "百",
				"十" };
		int u = 1000000000;
		String[] nums = new String[] { "零", "一", "二", "三", "四", "五", "六", "七",
				"八", "九" };
		StringBuilder sb = new StringBuilder();
		boolean started = false;
		for (int i = 0; i < unit.length; i++) {
			int n = x / u;
			if (!started) {

				started = n == 0 ? false : true;
			}
			if (started) {
				sb.append(nums[n]);
				sb.append(n == 0 ? "" : unit[i]);
			} else {
				sb.append(n == 0 ? "" : nums[n]);
				sb.append(n == 0 ? "" : unit[i]);
			}
			x %= u;
			u /= 10;
		}
		sb.append(nums[x]);
		while (sb.substring(sb.length() - 1, sb.length()).equals("零")) {
			sb.delete(sb.length() - 1, sb.length());
		}
		return sb.toString();
	}
}
