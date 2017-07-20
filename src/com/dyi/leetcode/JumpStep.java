package com.dyi.leetcode;

/**
 * 70.You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * @author WANYONGBO
 *
 */
public class JumpStep {
	private static int[] s;

	public static int climbStairs(int n) {
		s = new int[n + 1];
		return c(n);
	}

	private static int c(int n) {
		if (n < 3)
			return n;
		if (s[n] != 0)
			return s[n];
		int re = c(n - 1) + c(n - 2);
		s[n] = re;
		return re;
	}

	public static int climbStair(int n) {
		double k = Math.sqrt(5);
		double s1 = Math.pow((1 + k) / 2, n) - Math.pow((1 - k) / 2, n);
		s1 = s1 / k;
		return (int) s1;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++)
			System.out.println(climbStairs(i) + "--" + climbStair(i + 1));
	}
}
