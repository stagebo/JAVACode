package com.dyi.leetcode;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * click to show spoilers.
 * 
 * Note: The input is assumed to be a 32-bit signed integer. Your function
 * should return 0 when the reversed integer overflows.
 * 
 * @author Stagebo
 *
 */
public class ReverseInteger {

	public static void main(String[] args) {
		long t1 = System.nanoTime();
		System.out.println(new ReverseInteger().reverse(123456789));
		long t2 = System.nanoTime();
		long span = t2 - t1;

		System.out.println(new ReverseInteger().reverse2(123456789));
		long t3 = System.nanoTime();

		long span2 = t3 - t2;
		System.out.println("my method:" + span);
		System.out.println("common method:" + span2);
	}

	/**
	 * the anwser from internet
	 * 
	 * @param x
	 * @return
	 */
	public int reverse2(int x) {
		long result = 0;
		while (x != 0) {
			result = (result * 10) + (x % 10);
			if (result > Integer.MAX_VALUE)
				return 0;
			if (result < Integer.MIN_VALUE)
				return 0;
			x = x / 10;
		}
		return (int) result;
	}

	/**
	 * my method
	 * 
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		boolean isN = x < 0;
		x = Math.abs(x);
		StringBuilder s = new StringBuilder(x + "").reverse();
		try {
			x = Integer.parseInt(s.toString());
		} catch (Exception e) {
			return 0;
		}
		return isN ? -1 : x;
	}
}
