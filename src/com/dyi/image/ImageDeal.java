package com.dyi.image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;

public class ImageDeal {
	/**
	 * 按图片灰度值矩阵展示图片
	 * 
	 * @param img
	 * @param title
	 */
	public static void showImage(int[][] img, String title) {
		int h = img.length;
		int w = img[0].length;

		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++) {
				int gray = img[i][j];
				int rgb = ((255 & 0xFF) << 24) |
		                ((gray & 0xFF) << 16) |
		                ((gray & 0xFF) << 8)  |
		                ((gray & 0xFF) << 0);
				bi.setRGB(j,i, rgb);
			}
		ImageIcon icon = new ImageIcon();
		icon = new ImageIcon(bi);

		JFrame jf = new JFrame(title);
		JLabel jl = new JLabel();
		jf.setSize(w, h);
		jl.setSize(w, h);
		jl.setIcon(icon);
		jf.add(jl);

		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * 按路径展示图片
	 * 
	 * @param img
	 * @param title
	 */
	public static void showImage(String img, String title) {
		File file = new File(img);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(bi);
		int w = bi.getWidth();
		int h = bi.getHeight();
		JFrame jf = new JFrame(title);
		JLabel jl = new JLabel();
		jf.setSize(w, h);
		jl.setSize(w, h);
		jl.setIcon(icon);
		jf.add(jl);

		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * 按照文件显示图片
	 * @param file
	 * @param title
	 */
	public static void showImage(File file, String title) {		
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(bi);
		int w = bi.getWidth();
		int h = bi.getHeight();
		JFrame jf = new JFrame(title);
		JLabel jl = new JLabel();
		jf.setSize(w, h);
		jl.setSize(w, h);
		jl.setIcon(icon);
		jf.add(jl);

		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * 按照Rgb对象矩阵显示图片
	 * @param img
	 * @param title
	 */
	public static void showImage(Rgb[][] img, String title) {
		int h = img.length;
		int w = img[0].length;

		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++) {
				Rgb rgbModel = img[i][j];
				int r = rgbModel.r;
				int g = rgbModel.g;
				int b = rgbModel.b;
				int rgb = ((255 & 0xFF) << 24) |
		                ((r & 0xFF) << 16) |
		                ((g & 0xFF) << 8)  |
		                ((b & 0xFF) << 0);
				bi.setRGB(i, j, rgb);
			}
		ImageIcon icon = new ImageIcon();
		icon = new ImageIcon(bi);

		JFrame jf = new JFrame(title);
		JLabel jl = new JLabel();
		jf.setSize(w, h);
		jl.setSize(w, h);
		jl.setIcon(icon);
		jf.add(jl);

		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * 获取图片rgb值
	 * 
	 * @throws Exception
	 */
	public static Rgb[][] getImagePixel(String image) throws Exception {
		int[] rgb = new int[3];
		File file = new File(image);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int width = bi.getWidth();
		int height = bi.getHeight();
		int minx = bi.getMinX();
		int miny = bi.getMinY();
		Rgb[][] result = new Rgb[height][width];
		for (int i = minx; i < width; i++) {
			for (int j = miny; j < height; j++) {
				int pixel = bi.getRGB(i, j); // 下面三行代码将一个数字转换为RGB数字
				int r = (pixel & 0xff0000) >> 16;
				int g = (pixel & 0xff00) >> 8;
				int b = (pixel & 0xff);
				Rgb rgbModel = new Rgb(r, g, b);
				System.out.println(r+"-"+g+"-"+b);
				result[j][i] = rgbModel;
				
			}
		}
		return result;
	}
	
	
	public static int[][] getGrayImage(String image) throws Exception {
		int[] rgb = new int[3];
		File file = new File(image);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int width = bi.getWidth();
		int height = bi.getHeight();
		int minx = bi.getMinX();
		int miny = bi.getMinY();
		int[][] result = new int[height][width];
		for (int i = minx; i < width; i++) {
			for (int j = miny; j < height; j++) {
				int pixel = bi.getRGB(i, j); // 下面三行代码将一个数字转换为RGB数字
				int r = (pixel & 0xff0000) >> 16;
				int g = (pixel & 0xff00) >> 8;
				int b = (pixel & 0xff);
				int gray = (r*77+g*151+b*28)>>8;
				result[j][i] =gray;// (int)( 0.30 * b + 0.59 * g + 0.11 * r)
				
				
			}
		}
		return result;
	}

	/**
	 * 打开文件选择器选择图片
	 * @return File对象
	 */
	public static File openFile(){
		JFileChooser fd = new JFileChooser();  
		fd.setFileFilter(new ImageFilter());
		//fd.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  
		fd.showOpenDialog(null);  
		File f = fd.getSelectedFile(); 
		return f;
	}
}

/**
 * 图片选择过滤器
 * @author wyb
 *
 */
class ImageFilter extends FileFilter
{

    public boolean accept(File f)
    {
        if (f.isDirectory())
        {
            return true;
        }
        String fileName = f.getName();
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1); 
        if (extension != null)
        {
            if (extension.equals("gif") || extension.equals("jpeg")
                    || extension.equals("jpg") || extension.equals("png"))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }

    public String getDescription()
    {
        return "图片文件(*.jpg, *.jpeg, *.gif, *.png)";
    }
}