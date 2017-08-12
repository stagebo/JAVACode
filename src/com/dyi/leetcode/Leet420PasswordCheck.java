package com.dyi.leetcode;

/**
 * 420.A password is considered strong if below conditions are all met:
 * 
 * It has at least 6 characters and at most 20 characters. It must contain at
 * least one lowercase letter, at least one uppercase letter, and at least one
 * digit. It must NOT contain three repeating characters in a row ("...aaa..."
 * is weak, but "...aa...a..." is strong, assuming other conditions are met).
 * Write a function strongPasswordChecker(s), that takes a string s as input,
 * and return the MINIMUM change required to make s a strong password. If s is
 * already strong, return 0.
 * 
 * Insertion, deletion or replace of any one character are all considered as one
 * change.
 * 
 * @author WANYONGBO
 * @version 2017-8-8 16:04:07
 *
 */
public class Leet420PasswordCheck {
	/**
	 * 密码字符串强度校验 2017-8-8 16:46:08 未完成
	 * 
	 * @param s
	 *            密码字符串
	 * @return 需要修改的次数
	 */
	public int strongPasswordChecker(String s) {
		int tooLong = 0, hasInt = 1, hasUpper = 1, hasLower = 1, hasSame = 0, result = 0;
		if (s.length() < 6) {
			return 6 - s.length();
		} else if (s.length() > 20) {
			tooLong = s.length() - 20;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c <= 'z' && c >= 'a') {
				hasLower = 0;
			} else if (c <= 'Z' && c >= 'A') {
				hasUpper = 0;
			} else if (c <= '9' && c >= '0') {
				hasInt = 0;
			}
			if (i < s.length() - 2 && i < 18) {
				char m = s.charAt(i), n = s.charAt(i + 1), p = s.charAt(i + 2);
				if (m == n & n == p) {
					hasSame++;
					i += 2;
				}
			}
		}
		if (tooLong > 0) {
			if (tooLong > hasSame) {
				result = tooLong;
			} else {
				hasSame = hasSame >= (hasInt + hasUpper + hasLower) ? hasSame : hasInt + hasUpper + hasLower + hasSame;
				result = hasSame + tooLong;
			}
		} else if (hasSame >= (hasInt + hasUpper + hasLower)) {
			result = hasSame;
		} else {
			result = hasInt + hasUpper + hasLower + hasSame;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leet420PasswordCheck le = new Leet420PasswordCheck();
		String pwd = "aaaaaaaaaaaaaaaaaaaaa";
		pwd = "ABABABABABABABABABAB1";
		pwd = "1010101010aaaB10101010";
		System.out.println(le.strongPasswordChecker(pwd));
	}

}
