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
public class Leet321MaxNumber_02 {
	/**
	 * 2017年8月2日10:35:21:思路不正确，更改
	 * 
	 * @param n1
	 * @param n2
	 * @param k
	 * @return
	 */
	public int[] maxNumber(int[] n1, int[] n2, int k) {//思路再次错误。。。2017年8月2日11:09:15
		t=new int[k];
		this.k=k;
		this.n1=n1;
		this.n2=n2;
		solution(0);
		int[] result=list.get(0);
		for(int[] te:list){
			if(greatOrEquals(te, result, 0, 0)){
				result=te;
			}
		}
		return result;
	}
	private boolean greatOrEquals(int[] a,int[] b,int i,int j){
		for(;i<a.length&&j<b.length;i++,j++){
			if(a[i]>b[j])return true;
			else if(a[i]<b[j])return false;
		}

		if(i==a.length)return false;
		return true;
	}
	private ArrayList<int[]> list=new ArrayList<int[]>();
	private int[] t;
	private int k;
	private int[] n1;
	private int[] n2;
	private void solution(int n){
		if(n==k){
			int[] te=new int[k];
			for(int i=0;i<te.length;i++)
				te[i]=t[i];
			list.add(te);
		}
		int i=0,j=0;
		while(i<n1.length&&j<n2.length){
			t[n]=n1[i]>n2[j]?n1[i++]:n2[j++];
			solution(n+1);
		}
		while(i<n1.length){
			t[n]=n1[i++];
			solution(n+1);
		}
		while(j<n2.length){
			t[n]=n2[j++];
			solution(n+1);
		}
		
		
	}

	public static void main(String[] args) {
		int[] a = {3,4,6,5 }, b = { 9,1,2,5,8,3 };
		Leet321MaxNumber_02 m = new Leet321MaxNumber_02();
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(new Leet321MaxNumber_02().maxNumber(a, b, 5)));
	}
}
