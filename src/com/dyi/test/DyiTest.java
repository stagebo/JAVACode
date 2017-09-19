package com.dyi.test;

public class DyiTest {
	public static void main(String[] args) {
		System.out.println(java.net.URLDecoder.decode("st"));
		System.out.println(new Integer(1000)==1000);
		System.out.println(new Integer(1000)==new Integer(1000));
		Integer i=-128;
		Integer j=-128;
		System.out.println(i==j);
	}

	public static int maxRotateFunction(int[] A) {
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			int s = 0;
			for (int j = 0; j < A.length; j++)
				s = s + A[(j+i)%A.length] * j;
			System.out.println(s);
			sum = sum > s ? sum : s;
		}
		return sum;

	}
}
