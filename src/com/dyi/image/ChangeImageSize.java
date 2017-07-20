package com.dyi.image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ChangeImageSize {
	/**
	 * 将图像绘制成指定宽高。
	 * @param img
	 * @param width
	 * @param height
	 * @return
	 */
	public static BufferedImage changeImageSize(BufferedImage img, int width, int height) {
		BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = result.getGraphics();
		g.drawImage(img, 0, 0, width, height, null);
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		String fileName="C:\\Users\\WANYONGBO\\Desktop\\1.png";
		BufferedImage img=ImageIO.read(new File(fileName));
		img=changeImageSize(img, 16,16);
		ImageIO.write(img, "png", new File("C:\\Users\\WANYONGBO\\Desktop\\2.png"));
	}
}
