package com.dyi.leetcode;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * from:leetcode
 * 
 * website:https://leetcode.com/problems/sqrtx/#/description
 * 
 * @author Stagebo
 *
 */
public class SqrtX {

		/**
		 * calcul sqrt(x)
		 *  x2=x1-y/y'
		 *  y=x^2
		 *  y'=2x
		 * @param x
		 * @return
		 */
		public static int mySqrt(int x) {
			
			 if(x==0)return x;
		        if(x<4)return 1;
		        
		        int a=x;
		        x=x/2;
		        //x2=x1-y/y'
		       int k=100;
		        while(k-->0)
		        x= x-(x*x-a)/(x*2);
		        
		        if(x*x>a)return x-1;
		        return x;
		}
		/*
		 * m2-10=0;
		 * x1=10/2=5;
		 * x2=5-25/10;
		 * */
		public static void main(String[] args) {
			System.out.println(mySqrt(1030213023)+"    "+Math.sqrt(1030213023));
			System.out.println();
		}
	
}
