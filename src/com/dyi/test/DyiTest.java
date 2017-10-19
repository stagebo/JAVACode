package com.dyi.test;

public class DyiTest {
	public static void main(String[] args) {
		double[] b = new double[] { 1.0 / 3.0,1.0 / 3.0,1.0 / 3.0};
		double[][] a = new double[][] { { 0, 0.5, 0.5 }, { 1, 0, 0 }, { 0, 1, 0 } };
		a=new double[][]
				{
				{0,0.5,0,0},
				{1.0/3.0,0,0,0.5},
				{1.0/3.0,0,1,0.5},
				{1.0/3.0,0.5,0,0}
				
				};
		b=new double[]{0.25,0.25,0.25,0.25};
		double alf=0.85;
		double nx=0.15;
		for (int i = 0; i < 1000; i++) {
			double[] t = new double[b.length];
			for (int r = 0; r < a.length; r++) {
				for (int c = 0; c < a[0].length; c++) {
					t[r] += a[r][c] * b[c];
					
				}
				t[r]=t[r]*alf+nx/4;
			}

			printA(b);
			b=t;
		}

	}

	public static void printA(double[] d) {
		for (int i = 0; i < d.length; i++) {
			System.out.print(d[i] + ",");
		}
		System.out.println();
	}
}
