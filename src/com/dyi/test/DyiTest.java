package com.dyi.test;

public class DyiTest {
	public static void main(String[] args) {
		for (int i = 0; i < 9; i++) {
			
			for (int j = 0; j < 9; j++) {
				if (j ==3)
					break;
				System.out.print(j + "-");
			}
			System.out.println();
		}
	}
}
