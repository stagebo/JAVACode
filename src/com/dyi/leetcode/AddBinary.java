package com.dyi.leetcode;

/**
 * 67.Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 * @author WANYONGBO
 *
 */
public class AddBinary {
	public static String addBinary(String a, String b) {
		StringBuilder sa = new StringBuilder(a.length() > b.length() ? a : b).reverse(),
				sb = new StringBuilder(a.length() > b.length() ? b : a).reverse(), re = new StringBuilder();
		int k = 0, i = 0;
		for (; i < sa.length(); i++) {
			int sas = Integer.parseInt((sa.charAt(i) + ""));
			int sbs = Integer.parseInt(i < sb.length() ? sb.charAt(i)+"" : 0+"");
			int sum = sas + sbs + k;
			k = 0;
			re.append(sum % 2);
			k = sum / 2;
		}
		if (k == 1)
			re.append(k);

		return re.reverse().toString();
	}

	public static void main(String[] args) {
		String tes=Integer.toBinaryString(Integer.parseInt("10110110010111",2)+Integer.parseInt("10110010000",2));
		String tess=addBinary("10110110010111","10110010000");
		System.out.println(tes);
		System.out.println(tess);
		System.out.println(addBinary("1111", "1"));
		System.out.println(addBinary(
				"10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
				"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
	}
}
