package com.dyi.leetcode;

import java.util.Arrays;

/**
 * 37. Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution.
 * 
 * @author WANYONGBO
 *
 */
public class Leet037SodukuSolution {
	int arr[][];
	int brr[][]=new int[9][9];
	/**
	 * 
	 * @param r
	 * @param c
	 */
	public void solveSudoku(int r,int c) {
		if(r==9&&c==9){
			if(checked()){
				printArrays(arr);
			}
			return;
		}
		for(int i=1;i<10;i++){
			if(brr[r][c]==0)arr[r][c]=i;
			solveSudoku(r+1,c+1);
			if(brr[r][c]==0)arr[r][c]=0;
		}
	}
	
	private boolean checked() {
		// TODO Auto-generated method stub
		for(int i=0;i<9;i++){
			int sx[]=new int[9],sy[]=new int[9];
			for(int j=0;j<9;j++){
				sx[j]=arr[i][j];
				sy[j]=arr[j][i];
			}
			if(!checkArray(sx)||!checkArray(sy))return false;
		}
		int[] sm=new int[9],sn=new int[9];
		for(int i=0;i<9;i++){
			sm[i]=arr[i][i];
			sn[i]=arr[i][8-i];
		}
		if(!checkArray(sm)||!checkArray(sn))return false;
		return true;
	}
	private boolean checkArray(int[] a){
		Arrays.sort(a);
		for(int i=0;i<a.length;i++)
			if(a[i]!=i)return false;
		return true;
	}
	public static void main(String[] args) {
		int[][] b = { 
				{ 5, 3, 0, 0, 7, 0, 0, 0, 0 }, 
				{ 6, 0, 0, 1, 9, 5, 0, 0, 0 }, 
				{ 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, 
				{ 4, 0, 0, 8, 0, 3, 0, 0, 1 }, 
				{ 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, 
				{ 0, 0, 0, 4, 1, 9, 0, 0, 5 }, 
				{ 0, 0, 0, 0, 8, 0, 0, 7, 9 }
				};
		Leet037SodukuSolution s=new Leet037SodukuSolution();
		s.arr=b;
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				s.brr[i][j]=s.arr[i][j];
		
		s.solveSudoku(0,0);
	}
	public void printArrays(int[][] a){
		for(int[] b:a){System.out.println(Arrays.toString(b));}
	}
}
