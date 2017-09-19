package com.dyi.utils;

import java.util.Arrays;

public class ArrayUtils {

	/**
	 * �������
	 * 
	 * @param f
	 * @param arr
	 * @return
	 */
	public double[][] convolution(double[][] f, double[][] arr) {
		int w = arr[0].length - 2;
		int h = arr.length - 2;
		if (w < 1 || h < 1) {    
			return null;  
		}
		double[][] result = new double[h][w];
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= w; j++) {
				double[] t = new double[9];
				t[0] = f[0][0] * arr[i - 1][j - 1];
				t[1] = f[0][1] * arr[i - 1][j];
				t[2] = f[0][2] * arr[i - 1][j + 1];
				t[3] = f[1][0] * arr[i][j - 1];
				t[4] = f[1][1] * arr[i][j];
				t[5] = f[1][2] * arr[i][j + 1];
				t[6] = f[2][0] * arr[i + 1][j - 1];
				t[7] = f[2][1] * arr[i + 1][j];
				t[8] = f[2][2] * arr[i + 1][j + 1];
				double sum = 0;
				for (double tem : t)
					sum += tem;
				result[i - 1][j - 1] = sum;
			}

		}
		return result;
	}

	public static void printArrays(double[][] a) {
		System.out.println("**************************************");
		for (double[] b : a) {
			System.out.println(Arrays.toString(b));
		}
		System.out.println("**************************************");
	}

	public static void main(String[] args) {
		double[][] f = { { 1, 2, 1 }, { 0, 0, 0 }, { -1, -2, -1 } };
		double[][] a = { { 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } };
		double[][] re = new ArrayUtils().convolution(f, a);
		printArrays(f);
		printArrays(a);
		printArrays(re);
	}
}

class a {
	}