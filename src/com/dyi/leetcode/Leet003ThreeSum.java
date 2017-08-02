package com.dyi.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 3. Given an array S of n integers, are there elements a, b, c in S such that
 * a + b + c = 0? Find all unique triplets in the array which gives the sum of
 * zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * 4. Given an array S of n integers, are there elements a, b, c, and d in S
 * such that a + b + c + d = target? Find all unique quadruplets in the array
 * which gives the sum of target.
 * 
 * Note: The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 * 
 * @author Stagebo
 *
 */
public class Leet003ThreeSum {
	private int[] arr;
	private List<ArrayList<Integer>> re;
	private HashSet<String> hs;
	private int[] source;
	private int sum;
	private int number = 3;

	public List<ArrayList<Integer>> threeSum(int[] n, int sum, int number) {
		re = new ArrayList<ArrayList<Integer>>();
		hs = new HashSet<String>();
		source = n;
		this.sum = sum;
		this.number = number;
		arr = new int[number];
		solution(0);

		for (String s : hs) {
			ArrayList<Integer> l = new ArrayList<Integer>();
			for (String c : s.split(",")) {
				l.add(Integer.parseInt(c.trim()));
			}
			re.add(l);
		}
		return re;
	}

	/* 求全解，用回溯法。 */
	public void solution(int x) {
		if (x == number) {
			int sumTemp = 0;
			for (int i = 0; i < number; i++) {
				sumTemp += arr[i];
			}
			if (sumTemp == sum) {
				int[] tarr = Arrays.copyOf(arr, arr.length);
				Arrays.sort(tarr);
				String s = Arrays.toString(tarr).trim();
				s = s.substring(1, s.length() - 1);
				hs.add(s);
			}
			return;
		}
		for (int i = x + 1; i < source.length; i++) {
			arr[x] = source[i];
			int sumTemp = 0;
			for (int k = 0; k <= x; k++)
				sumTemp += arr[k];
			solution(x + 1);
		}
	}

	public void printList() {
		System.out.println("**********" + Arrays.toString(arr) + "," + sum + "," + number + ",Start************");
		for (List<Integer> l : re) {
			for (Integer i : l) {
				System.out.print(i + "  ");
			}
			System.out.println();
		}
		System.out.println("**********" + Arrays.toString(arr) + "," + sum + "," + number + ",End************");
	}

	public static void main(String[] args) {
		Leet003ThreeSum t = new Leet003ThreeSum();
		/* 测试ThreeSum */
		int[] n = new int[] { -1, 0, 1, 2, -1, -4 };
		t.threeSum(n, 0, 3);
		t.printList();
		/* 测试FourSum */
		n = new int[] { 1, 0, -1, 0, -2, 2 };
		t.threeSum(n, 0, 4);
		t.printList();
	}
}
