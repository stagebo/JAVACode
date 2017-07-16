package com.dyi.leetcode;

public class Test_01 {
	public static void main(String[] args) {
		int[] i = new int[] {8,9,3,1,8,3,0,6,9,2};
		System.out.println(m(i, 8));
		int[] k=new int[i.length];
		System.arraycopy(i, 0, k, 0, i.length);
		for(int ii=0;ii<k.length;ii++)System.out.println(k[ii]);
		System.out.println("abc".compareTo("abd"));
		
		
	}

	public static double m(int[] nums, int k) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int[] a = new int[nums.length - k+1];
		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = 0; j < k; j++) {
				sum = sum + nums[j + i];
			}
			a[i] = sum;
		}
		int max = a[0];
		for (int m = 0; m < a.length; m++) {
			if (a[m] > max)
				max = a[m];
		}
		double maxx = max;
		maxx /= k;
		return maxx;
	}
}
