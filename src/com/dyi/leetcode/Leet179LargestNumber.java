package com.dyi.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leet179LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] n = new int[]{0,0};
		String re = largestNumber(n);
		System.out.println(re);

	}
	public static String largestNumber(int[] nums){
		
		Comparator<String> com = new Comparator<String>() {			
			public int compare(String a, String b) {
				// TODO Auto-generated method stub
				return (a+b).compareTo(b+a);
			}
		};
		String[] str = new String[nums.length];
		for(int i=0;i<nums.length;i++){
			str[i]=nums[i]+"";
		}
		Arrays.sort(str,com);
		if(str[0].equals("0")){
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for(String s : str)sb.append(s);
		return sb.toString();
	}
	
}
