package com.dyi.leetcode;

import java.util.ArrayList;

/**
 * 202.Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 
 * 12 + 92 = 82 82 + 22 = 68 62 + 82 = 100 12 + 02 + 02 = 1
 * 
 * @author WANYONGBO
 *
 */
public class Leet202IsHappyNumber {
	ArrayList<Integer> l = new ArrayList<Integer>();

	public boolean isHappy(int n) {
		System.out.print(n+" ");
		int temp = n;
		if (l.contains(n)) {
			System.out.println();
			return false;
		}

		int sum = 0;
		while (n != 0) {
			int t = n % 10;
			sum = sum + t * t;
			n = n / 10;

		}
		if (sum == 1) {
			System.out.println();
			return true;
		}
		l.add(temp);
		return isHappy(sum);

	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++)
			System.out.println(i + ":" + new Leet202IsHappyNumber().isHappy(i));
	}
}
