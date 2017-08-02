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
public class Leet070JumpStep {
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
		long t1=System.currentTimeMillis();
		for (int i = 0; i < 200; i++)
			System.out.println(climbStairs(i));
		long t2=System.currentTimeMillis();
		for (int i = 0; i < 200; i++)
			System.out.println(climbStair(i));
		long t3=System.currentTimeMillis();
		System.out.println(t2-t1);
		System.out.println(t3-t2);
	}
}
