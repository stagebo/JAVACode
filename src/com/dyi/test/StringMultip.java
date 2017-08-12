package com.dyi.test;

/**
 * 两个字符串分别代表两个数，算出这两个数的乘积
 * 
 * @author WANYONGBO
 * @version 2017-8-9 15:39:47
 */
public class StringMultip {
	public static void main(String[] args) {
		long a = 54324342344234651L;
		int b = 52342234;
		System.out.println(a * b);
		System.out.println(multStrings(a + "", b));
		System.out.println(multipLargeNumber(a + "", b + ""));
	}

	/**
	 * 算出两个数的乘积
	 * 
	 * @param n1
	 *            String 代表数字的字符串
	 * @param n2
	 *            String 代表数字的字符串
	 * @return 两个数的乘积
	 */
	public static String multipLargeNumber(String n1, String n2) {
		String result = "";
		for (int i = n2.length() - 1; i >= 0; i--) {
			int m = n2.charAt(i) - '0';
			String ret = multStrings(n1, m);
			for (int k = 0; k < n2.length() - 1 - i; k++)
				ret += "0";
			result = addStrings(result, ret);

		}

		return result;
	}

	/**
	 * 算出字符串所代表的数和一个0-9的数字相乘的结果
	 * 
	 * @param s
	 *            String 代表一个数的字符串
	 * @param n
	 *            数字，0<=n<=9
	 * @return 结果字符串
	 */
	public static String multStrings(String s, int n) {
		int carry = 0;
		StringBuilder re = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int m = (s.charAt(s.length() - 1 - i) - '0') * n + carry;
			re.append(m % 10);
			carry = m / 10;
		}
		re.append(carry == 0 ? "" : carry + "");
		return re.reverse().toString();
	}

	/**
	 * 两个整数相加的结果
	 * 
	 * @param num1
	 *            String 代表一个数的字符串
	 * @param num2
	 *            String 代表一个数的字符串
	 * @return 两个数相乘的结果
	 */
	public static String addStrings(String num1, String num2) {
		StringBuilder re = new StringBuilder();
		int carry = 0;
		int i = 0;
		while (i < num1.length() && i < num2.length()) {
			int m = num1.charAt(num1.length() - i - 1) - '0' + num2.charAt(num2.length() - 1 - i) - '0' + carry;
			re.append(m % 10);
			carry = m / 10;
			i++;
		}
		while (i < num1.length()) {
			int m = num1.charAt(num1.length() - i - 1) - '0' + carry;
			re.append(m % 10);
			carry = m / 10;
			i++;
		}
		while (i < num2.length()) {
			int m = num2.charAt(num2.length() - i - 1) - '0' + carry;
			re.append(m % 10);
			carry = m / 10;
			i++;
		}
		re.append(carry == 1 ? "1" : "");
		return re.reverse().toString();
	}
}
