package com.dyi.leetcode;

/**
 * 342.Given an integer (signed 32 bits), write a function to check whether it
 * is a power of 4.
 * 
 * Example: Given num = 16, return true. Given num = 5, return false.
 * 
 * Follow up: Could you solve it without loops/recursion?
 * 
 * 时间：2017年8月8日08:09:25
 * 
 * @author WANYONGBO
 *
 */
public class Leet342IsPowerOfFour {
	public boolean isPowerOfFour(int num) {
		
		/*if (Integer.bitCount(num) == 1&&(Integer.toBinaryString(num).length()+1)%2==0)
		return true;
		return false;*/
		double t = Math.sqrt(num);
		return (int) Math.pow(2, 30) % t == 0;

	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE > Math.pow(2, 31));
		for (int i = 0; i < 10; i++)
			System.out.println(Integer.toBinaryString((int) Math.pow(3, i)));

		/* System.out.println(Integer.toBinaryString(0x55555555)); */
		for (int i = 4; i < 10000; i++)
			if (new Leet342IsPowerOfFour().isPowerOfFour(i))
				System.out.println(i);
	}
}
