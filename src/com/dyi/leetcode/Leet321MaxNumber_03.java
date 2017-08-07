package com.dyi.leetcode;

import java.util.ArrayList;
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
public class Leet321MaxNumber_03 {
	/**
	 * 2017年8月2日10:35:21:思路不正确，更改
	 * 
	 * @param n1
	 * @param n2
	 * @param k
	 * @return
	 */
	public int[] maxNumber(int[] n1, int[] n2, int k) {
		result = new int[k];
		this.n1 = n1;
		this.n2 = n2;
		this.k = k;
		this.sumLen = n1.length + n2.length;
		copyArrays();
		solution(0);
		return result;
	}

	private void copyArrays() {
		// TODO Auto-generated method stub
		nsum = new int[2][n1.length + n2.length];
		int index = 0;
		for (int i = 0; i < n1.length; i++) {
			nsum[0][index] = n1[i];
			nsum[1][index] = 0;
			index++;
		}
		for (int j = 0; j < n2.length; j++) {
			nsum[0][index] = n2[j];
			nsum[1][index] = 0;
			index++;
		}
	}

	private int[] n1;
	private int[] n2;
	private int[][] nsum;
	private int k;
	private int[] result;
	private int sumLen;

	public void solution(int n) {
		if (n == k) {
			if (isLegal()) {
				System.out.println(Arrays.toString(result));
				return;
			}
		}
		for (int i = 0; i < nsum.length; i++) {
			int max = getMaxIndex();
			if (yetLegal(max, n)) {
				result[n] = max;
				nsum[1][max] = 1;
				solution(n + 1);
				nsum[1][max] = 0;
			}
		}

	}

	private boolean yetLegal(int max, int n) {
		// TODO Auto-generated method stub
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			if(result[i]>=n1.length)
				l2.add(result[i]);
			else 
				l1.add(result[i]);			
		}
		if(max>0){
			if(max>=n1.length)l2.add(max);
			else l1.add(max);
		}
		for(int i=0;i<l1.size()-1;i++){
			if(l1.get(i)>l1.get(i+1))return false;
		}
		for(int i=0;i<l2.size()-1;i++){
			if(l2.get(i)>l2.get(i+1))return false;
		}
		return true;
	}

	private int getMaxIndex() {
		// TODO Auto-generated method stub
		int maxIndex = 0;
		for (int i = 0; i < nsum[0].length; i++) {
			if (nsum[0][maxIndex] < nsum[0][i] && nsum[1][i] == 0) {
				maxIndex = i;
			}
		}
		
		return nsum[1][maxIndex] == 0 ? maxIndex : -1;
	}

	public boolean isLegal() {
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		for(int i=0;i<k;i++)
		{
			if(result[i]>=n1.length)
				l2.add(result[i]);
			else 
				l1.add(result[i]);			
		}
		
		for(int i=0;i<l1.size()-1;i++){
			if(l1.get(i)>l1.get(i+1))return false;
		}
		for(int i=0;i<l2.size()-1;i++){
			if(l2.get(i)>l2.get(i+1))return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] a = { 3, 4, 6, 5 }, b = { 9, 1, 2, 5, 8, 3 };
		Leet321MaxNumber_03 m = new Leet321MaxNumber_03();
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(new Leet321MaxNumber_03().maxNumber(a, b, 5)));
	}
}
