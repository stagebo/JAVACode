package com.dyi.leetcode;

public class MathPowImpl {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(myPow(2, -2));
	}

	public static double myPow(double x, int n) {
		if (n == 0)
			return 1;
		double re = x;
		if (n > 0) {
			int i = 1;
			while (i < n) {
				if (i * 2 < n) {
					re *= re;
					i *= 2;
				} else {
					re *= x;
					i++;
				}
			}
			return re;
		} else {
			int i = -1;
			while (i > n) {
				if (i * 2 > n) {
					re *= re;
					i *= 2;
				} else {
					re *= x;
					i--;
				}
			}
			return 1 / re;
		}
	}
}
