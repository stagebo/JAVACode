package com.dyi.leetcode;

import java.util.Arrays;

/**
 * 321.Given two arrays of length m and n with digits 0-9 representing two
 * numbers. Create the maximum number of length k <= m + n from digits of the
 * two. The relative order of the digits from the same array must be preserved.
 * Return an array of the k digits. You should try to optimize your time and
 * space complexity.
 * 
 * Example 1: nums1 = [3, 4, 6, 5] nums2 = [9, 1, 2, 5, 8, 3] k = 5 return [9,
 * 8, 6, 5, 3]
 * 
 * Example 2: nums1 = [6, 7] nums2 = [6, 0, 4] k = 5 return [6, 7, 6, 0, 4]
 * 
 * Example 3: nums1 = [3, 9] nums2 = [8, 9] k = 3 return [9, 8, 9]
 * 
 * @author WANYONGBO
 *
 */
public class Leet321MaxNumber_01 {
	/**
	 * 2017年8月2日10:35:21:思路不正确，更改
	 * 
	 * @param n1
	 * @param n2
	 * @param k
	 * @return
	 */
	public int[] maxNumber(int[] n1, int[] n2, int k) {//思路再次错误。。。2017年8月2日11:09:15
		int[] merge = new int[n1.length + n2.length];
		int index = 0;
		while (index < merge.length) {
			if (index < n1.length)
				merge[index] = n1[index++];
			else
				merge[index] = n2[index++ - n1.length];
		}
		System.out.println(Arrays.toString(merge));
		int[] max = new int[k];
		index = 0;
		while (index < k)
			max[index] = index++;
		System.out.println(Arrays.toString(max));

		while (index < merge.length) {// find top k.
			for (int i = 0; i < k; i++) {
				if (merge[index] > merge[max[i]]) {
					int min = 0;
					for (int ii = 0; ii < k; ii++)
						if (merge[max[ii]] < merge[max[min]])
							min = ii;
					max[min] = index++;
					break;
				}
				index++;
			}
		}
		System.out.println(Arrays.toString(max));
		Arrays.sort(max);
		System.out.println(Arrays.toString(max));
		int i = 0, j = 0;
		for (int m = 0; m < k; m++)
			if (max[m] < n1.length)
				j++;
		int[] result = new int[k];
		index = 0;
		int p = 0, q = j;
		while (p < j && q < max.length) {
			if (merge[max[p]] > merge[max[q]]) {
				result[index++] = merge[max[p++]];
			} else {
				result[index++] = merge[max[q++]];
			}
		}
		while (p < j)
			result[index++] = merge[max[p++]];
		while (q < max.length)
			result[index++] = merge[max[q++]];
		return result;

	}

	public static void main(String[] args) {
		int[] a = {3,4,6,5 }, b = { 9,1,2,5,8,3 };
		Leet321MaxNumber_01 m = new Leet321MaxNumber_01();
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(new Leet321MaxNumber_01().maxNumber(a, b, 5)));
	}
}
