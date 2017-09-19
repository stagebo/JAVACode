package com.dyi.leetcode;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row. For example,
 * 
 * Consider the following matrix:
 * 
 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] Given target = 3, return
 * true.
 * 
 * @author WANYONGBO
 * 
 */
public class Leet074Search2DMatrix {
	public static void main(String[] args) {
		int[][] matrix = new int[][] { new int[] { 1, 3, 5, 7 },
				new int[] { 10, 11, 16, 20 }, new int[] { 23, 30, 34, 50 } };
		System.out.println(searchMatrix(matrix, 6));
	}

	public static boolean searchMatrix(int[][] ma, int t) {
		int m =ma.length;
		int n= ma[0].length;
		if(m<1||n<1){
			return false;
		}
		if(t<ma[0][0]||t>ma[m-1][n-1]){
			return false;
		}
			
		int mi=0;
		for(mi=0;mi<m;mi++){
			if(ma[mi][n-1]>=t){
				break;
			}
		}
		for(int i=0;i<n;i++){//用二分查找优化
			if(ma[mi][i]==t){
				return true;
			}
		}
		return false;
	}
}
