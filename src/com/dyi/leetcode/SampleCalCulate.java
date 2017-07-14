package com.dyi.leetcode;

/**
 * +-* /简单四则运算--字符串实现方式
 * from:leetcode
 * 
 * @author Stagebo
 * 
 */
public class SampleCalCulate {
	public static void main(String[] args) {
		String s = "11+1*33+3/2";
		s = "021+1-9/2";
		System.out.println(calculate(s));
	}

	/**
	 * 简单加减乘除字符串解析
	 * 
	 * @param s
	 *            运算字符串
	 * @return int 运算结果
	 */
	public static int calculate(String s) {
		s = s.replace(" ", "");
		String[] sNum = s.split("[+-/*]");
		String[] cNum = s.split("[0123456789]+");
		if (cNum.length > 1) {
			String[] temp = new String[cNum.length - 1];
			for (int i = 0; i < temp.length; i++)
				temp[i] = cNum[i + 1];
			cNum = temp;
		}
		String[] str = new String[sNum.length + cNum.length];
		int index = 0;
		for (int i = 0; i < cNum.length; i++) {
			str[index++] = sNum[i];
			str[index++] = cNum[i];

		}
		int k = str.length;
		str[str.length - 1] = sNum[sNum.length - 1];
		/* 处理乘和除 */
		for (int i = 0; i < str.length; i++) {
			if ("*".equals(str[i])) {
				int a = Integer.parseInt(str[i - 1]) * Integer.parseInt(str[i + 1]);
				str[i - 1] = 0 + "";
				str[i] = i > 2 ? str[i - 2] : "+";
				str[i + 1] = a + "";

			} else if ("/".equals(str[i])) {
				int a = Integer.parseInt(str[i - 1]) / Integer.parseInt(str[i + 1]);
				str[i - 1] = 0 + "";
				str[i] = i > 2 ? str[i - 2] : "+";
				str[i + 1] = a + "";
			}

		}
		int sum = Integer.parseInt(str[0]);
		/* 处理加和减 */
		for (int i = 1; i < str.length; i++) {
			if (str[i] == null)
				continue;
			if ("+".equals(str[i])) {
				sum += Integer.parseInt(str[i + 1]);
			} else if ("-".equals(str[i])) {
				sum -= Integer.parseInt(str[i + 1]);
			}

		}
		return sum;
	}
}
