package com.dyi.test;

import java.util.Arrays;

import Jama.Matrix;

public class JamaTest {
	public static void main(String[] args) {
		 double[][] array = {{1.,2.,3},{4.,5.,4.},{7.,8.,10.}}; 
		 StringBuilder sb =new StringBuilder("123");
		 StringBuilder sa =new StringBuilder("123");
		 System.out.println(sb.equals(sa));
	      Matrix A = new Matrix(array); 
	      Matrix b = Matrix.random(3,1); 
	      Matrix x = A.solve(b); 
	      Matrix Residual = A.times(x).minus(b); 
	      
	      double rnorm = Residual.normInf();
	      Matrix aa=new Matrix(new double[][]{{1,2,3},{4,5,6}});
	      Matrix bb=new Matrix(new double[][]{{1,4},{2,5},{3,6}});
	      Matrix rr=aa.times(bb);
	      rr=aa.times(bb);
	     // Matrix cc = rr.arrayLeftDivide(aa.uminus());
	      printArr(bb.inverse().getArray());
	      System.out.println();
	      printArr(rr.times(bb.inverse()).getArray());
	     
	}
	public static void printArr(double[][] arr){
		for(int i=0;i<arr.length;i++)
			System.out.println(Arrays.toString(arr[i]));
	}
}
