package com.dyi.image;

import java.io.File;

public class ImageTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String fileName = "C:\\Users\\wyb\\Desktop\\2.png";
		 fileName = "C:\\Users\\wyb\\Desktop\\1.jpg";
		//File file = ImageDeal.openFile();
		int[][] r = ImageDeal.getGrayImage(fileName);
		for(int i=0;i<r[0].length;i++)
		{
			for(int j=0;j<r.length;j++)
				System.out.print(r[i][j]+"  ");
			System.out.println();
		}
		
		ImageDeal.showImage(r, "我勒个去");
		
		
	}

}
