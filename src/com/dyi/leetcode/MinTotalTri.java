package com.dyi.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle [ [2], [3,4], [6,5,7], [4,1,8,3] ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note: Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 * 
 * @author Stagebo
 *
 */
public class MinTotalTri {
	public static void main(String[] args) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		//[[-1],[2,3],[1,-1,-3]]
		List<Integer> l2=new ArrayList<Integer>();
		l2.add(-1);
		l.add(l2);
		
		l2=new ArrayList<Integer>();
		l2.add(2);
		l2.add(3);
		l.add(l2);
		
		l2=new ArrayList<Integer>();
		l2.add(1);
		l2.add(-1);
		l2.add(-3);
		l.add(l2);
		
		System.out.println(minimumTotal(l));

	}

	public static int minimumTotal(List<List<Integer>> t) {
		int sum = 0;
		int min;
		int minIndex=0;
		List<Integer> l0=t.get(0);
		for(int i=1;i<l0.size();i++)if(l0.get(i)<l0.get(minIndex))minIndex=i;
		for (List<Integer> l : t) {
			if(l.get(minIndex)>l.get(minIndex)){
				min = l.get(minIndex+1);
				minIndex++;
			}else{
				min = l.get(minIndex);
			}
			if(minIndex-1<l.size()-1&&minIndex-1>0){
				if(min<l.get(minIndex)-1){min=l.get(minIndex);minIndex--;}
			
			}
			sum += min;
			System.out.println(min);
		}
		return sum;

	}
}
