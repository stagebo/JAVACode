/*package com.dyi.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

*//**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and
 * the 6 LEDs on the bottom represent the minutes (0-59).
 * 
 * �� �� �� ����hour�� �� �� �� �� ����mins��.
 * 
 * Each LED represents a zero or one, with the least significant bit on the
 * right.
 * 
 * 
 * For example, the above binary watch reads "3:25".
 * 
 * Given a non-negative integer n which represents the number of LEDs that are
 * currently on, return all possible times the watch could represent.
 * 
 * Example:
 * 
 * Input: n = 1 Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04",
 * "0:08", "0:16", "0:32"] Note: The order of output does not matter. The hour
 * must not contain a leading zero, for example "01:00" is not valid, it should
 * be "1:00". The minute must be consist of two digits and may contain a leading
 * zero, for example "10:2" is not valid, it should be "10:02".
 * 
 * @author WANYONGBO
 *
 *//*
public class BinaryWatch {
	*//**
	 * һ��4+6=10���ƣ���1�������0�����ʮ���Ʒֱ���ķ�����Ϊ�� 480,240,120,60,32,16,8,4,2,1
	 * ��һ�������n��1��10-n��0��ϵ������� �ڶ������������Ӧ�����������ʱ�䣬ͬʱȥ������ʱ�䡣 ����
	 * 
	 * @param num
	 * @return
	 *//*
	public static List<String> readBinaryWatch(int num) {
		List<String> times = new ArrayList<String>();
		for (int h = 0; h < 12; h++)
			for (int m = 0; m < 60; m++)
				if (Integer.bitCount(h * 64 + m) == num)
					times.add(String.format("%d:%02d", h, m));
		return times;
	}

	public static List<String> readBinaryWatchs(int num) {
		String str = String.join(",", getString(num).split(""));
		run(str);
		List<String> l2 = new ArrayList<String>();

		for (String time : l) {
			int sumMin = 0;
			for (int i = 0; i < time.length(); i++) {
				int minutes = timeTable[i] * (time.charAt(i) == on ? 1 : 0);
				sumMin += minutes;
			}
			int hours = sumMin / 60;
			if (hours > 11) {
				continue;
			}
			int minues = sumMin % 60;
			String minuesString = minues < 10 ? "0" + minues : minues + "";
			l2.add(hours + ":" + minuesString);
		}
		return l2;
	}

	*//**
	 * ȫ�������������ٷ�ʵ�֣��¼�����Ⱥͻ��ݷ�һ�£����ŵ�~
	 * 
	 * @param str
	 *//*
	public static void run(String str) {
		System.out.println("Start!");
		strs = str.split(",");
		for (int i = 0; i < strs.length; i++) {
			strs[i] += i;
		}
		arr = new String[strs.length];
		solution(0);
	}

	public static void solution(int n) {
		if (n == strs.length) {
			 ȥ�� 
			l.add(String.join("", arr).replaceAll("\\d+", ""));
			return;
		}
		for (int i = 0; i < strs.length; i++) {
			arr[n] = strs[i];
			if (check(n)) {
				solution(n + 1);
			}
		}
	}

	public static boolean check(int n) {
		for (int i = 0; i < n; i++) {
			if (arr[i] == arr[n] && i != n) {
				return false;
			}
		}
		return true;
	}

	public static String getString(int n) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i++ < n)
			sb.append(on);
		while (i++ <= 10)
			sb.append(off);
		return sb.toString();
	}

	public static void printSet(HashSet<String> l2) {
		for (String o : l2) {
			System.out.println(o.toString());
		}
	}

	public static void main(String[] args) {
		System.out.println(getString(1));
		List<String> re = readBinaryWatch(1);
		for (String s : re)
			System.out.println(s);
	}

	private static String[] strs;
	private static HashSet<String> l = new HashSet<String>();
	private static String[] arr;
	private static char on = 'T';
	private static char off = 'F';
	private static int[] timeTable = { 480, 240, 120, 60, 32, 16, 8, 4, 2, 1 };
}
*/