package com.dyi.leetcode;

/**
 * 88.Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note: You may assume that nums1 has enough space (size that is greater or
 * equal to m + n) to hold additional elements from nums2. The number of
 * elements initialized in nums1 and nums2 are m and n respectively.
 * 
 * @author WANYONGBO
 *
 */
public class Leet088MergeTwoSortedArray {
	/**
	 * 归并排序最后一步，合并两个子表
	 * @param n1
	 * @param m
	 * @param n2
	 * @param n
	 */
	public static void merge(int[] n1, int m, int[] n2, int n) {

		int i = m - 1, j = n - 1, index = m + n - 1;
		while (i >= 0 && j >= 0)
			n1[index--] = n1[i] > n2[j] ? n1[i--] : n2[j--];
		while (i > 0)
			n1[index--] = n1[i--];
		while (j > 0)
			n1[index--] = n2[j--];
	}
	
	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 7, 9, 0, 0, 0, 0, 0, 0, 0, 0 };
		int[] b = { 2, 4, 6, 8, 10 };
		printArray(a, 5);
		printArray(b);
		merge(a, 5, b, 5);
		printArray(a, 10);
	}

	public static void printArray(int[] a) {
		printArray(a, a.length);
	}

	public static void printArray(int[] a, int n) {
		System.out.println("**************************************");
		for (int i = 0; i < n; i++) {
			System.out.println(a[i] + "#");
		}
		System.out.println();
	}
}
