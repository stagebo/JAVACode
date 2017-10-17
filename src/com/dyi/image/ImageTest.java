package com.dyi.image;

import java.io.File;
import java.util.List;

public class ImageTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String fileName = "C:\\Users\\wyb\\Desktop\\2.png";
		 fileName = "C:\\Users\\wyb\\Desktop\\1.jpg";
		//File file = ImageDeal.openFile();
		int[][] r = ImageDeal.getGrayImage(fileName);
		System.out.println(r[320][105]);
		System.out.println(r[533][159]);
		List<int[]> re = ImageDeal.pickPoint(r);
		if(re.size()<1){
			System.out.println("选点失败！");
			return;
		}
		for(int[] xy:re){
			int x = xy[0],y = xy[1];
			System.out.println(x+"--"+y+":"+r[x][y]);
		}
		//ImageDeal.showImage(r, "我勒个去");
		
		
	}

}
