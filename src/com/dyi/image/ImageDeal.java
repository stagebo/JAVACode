package com.dyi.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.Transparency;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;

import Jama.Matrix;

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
				int rgb = ((255 & 0xFF) << 24) | ((gray & 0xFF) << 16)
						| ((gray & 0xFF) << 8) | ((gray & 0xFF) << 0);
				bi.setRGB(j, i, rgb);
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
	 * 按图片灰度值矩阵展示图片
	 * 
	 * @param img
	 * @param title
	 */
	public static void showImage(double[] imgs, String title, int w, int rgb) {
		int h = imgs.length / w;
		int[][] img = new int[imgs.length / w][w];
		for(int i=0;i<h;i++){
			for(int j=0;j<w;j++){
				img[i][j] = (int)imgs[i*w+j];
			}
		}
		printArr(img);
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++) {
				int gray = img[i][j];
				if (gray == 1) {
					bi.setRGB(j, i, rgb);
				} else {
					bi.setRGB(j, i, 0xff000000);
				}

			}
		bi =  changeImageSize(bi,300,300);
		ImageIcon icon = new ImageIcon();
		icon = new ImageIcon(bi);
		w=400;h=400;
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
	 * 
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
	 * 
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
				int rgb = ((255 & 0xFF) << 24) | ((r & 0xFF) << 16)
						| ((g & 0xFF) << 8) | ((b & 0xFF) << 0);
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
				System.out.println(r + "-" + g + "-" + b);
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
				int gray = (r * 77 + g * 151 + b * 28) >> 8;
				result[j][i] = gray;// (int)( 0.30 * b + 0.59 * g + 0.11 * r)

			}
		}
		return result;
	}
	public static int[][] getGrayImage(BufferedImage img) throws Exception {
		BufferedImage bi = img;
		
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
				int gray = (r * 77 + g * 151 + b * 28) >> 8;
				result[j][i] = gray;// (int)( 0.30 * b + 0.59 * g + 0.11 * r)

			}
		}
		return result;
	}
	/**
	 * 打开文件选择器选择图片
	 * 
	 * @return File对象
	 */
	public static File openFile() {
		JFileChooser fd = new JFileChooser();
		// 添加图片文件过滤器。只显示图片文件类型
		fd.setFileFilter(new FileFilter() {

			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				}
				String fileName = f.getName();
				String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
				if (extension != null) {
					if (extension.equals("gif") || extension.equals("jpeg")
							|| extension.equals("jpg")
							|| extension.equals("png")) {
						return true;
					} else {
						return false;
					}
				}
				return false;
			}

			public String getDescription() {
				return "图片文件(*.jpg, *.jpeg, *.gif, *.png)";
			}
		});

		fd.showOpenDialog(null);
		File f = fd.getSelectedFile();
		return f;
	}

	/**
	 * 选择图片上的点 线程中不可用----待修复bug
	 * 
	 * @param img
	 * @return
	 */
	public static List<int[]> pickPoint(int[][] img) {
		int h = img.length;
		int w = img[0].length;
		String title = "请点击图片选择目标点";
		// 结束选点标志
		final boolean[] canReturn = new boolean[] { false };
		final List<int[]> l = new ArrayList<int[]>();

		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++) {
				int gray = img[i][j];
				int rgb = ((255 & 0xFF) << 24) | ((gray & 0xFF) << 16)
						| ((gray & 0xFF) << 8) | ((gray & 0xFF) << 0);
				bi.setRGB(j, i, rgb);
			}
		ImageIcon icon = new ImageIcon();
		icon = new ImageIcon(bi);

		// 重写绘制事件
		final JFrame jf = new JFrame(title) {
			public void paint(Graphics g) {
				super.paint(g);
				Graphics2D g_2d = (Graphics2D) g;
				int index = 1;
				for (int[] aim : l) {
					int x = aim[0] + 7;
					int y = aim[1] + 30;
					g_2d.setColor(Color.RED);
					g_2d.fillOval(x - 5, y - 5, 10, 10);
					g_2d.setFont(new Font("宋体", Font.BOLD, 20));
					g_2d.drawString("" + index++, x + 10, y + 10);
				}
			}
		};

		JLabel jl = new JLabel();
		jf.setSize(w + 100, h);
		jf.setLayout(null);
		jl.setSize(w, h);
		jl.setIcon(icon);
		jf.add(jl);
		JButton jb = new JButton("结束描点");
		jb.setBounds(w + 10, 10, 80, 30);
		jf.add(jb);

		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 监控点击选点事件
		jl.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.getX();
				int y = e.getY();
				l.add(new int[] { x, y });
				jf.repaint();
				// int gray = img[y][x];
				// System.out.println(x+"--"+y);
			}
		});

		// 监控结束选点点击事件
		jb.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				canReturn[0] = true;
			}
		});
		while (true) {
			if (canReturn[0]) {
				jf.dispose();
				return l;
			}
			// 睡眠一下，防止程序过多耗用空间
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 选择图片上的点
	 * 
	 * @param img
	 * @return
	 */
	public static List<int[]> pickPoint(Image img) {
		int w = img.getWidth(null);
		int h = img.getHeight(null);
		String title = "请点击图片选择目标点";
		final List<int[]> l = new ArrayList<int[]>();
		final boolean[] canReturn = new boolean[1];
		canReturn[0] = false;
		BufferedImage bi = toBufferedImage(img);

		ImageIcon icon = new ImageIcon();
		icon = new ImageIcon(bi);

		// 重写绘制事件
		final JFrame jf = new JFrame(title) {
			public void paint(Graphics g) {
				super.paint(g);
				Graphics2D g_2d = (Graphics2D) g;
				int index = 1;
				for (int[] aim : l) {
					int x = aim[0] + 7;
					int y = aim[1] + 30;
					g_2d.setColor(Color.RED);
					g_2d.fillOval(x - 5, y - 5, 10, 10);
					g_2d.setFont(new Font("宋体", Font.BOLD, 20));
					g_2d.drawString("" + index++, x + 10, y + 10);
				}
			}
		};

		JLabel jl = new JLabel();
		jf.setSize(w + 100, h);
		jf.setLayout(null);
		jl.setSize(w, h);
		jl.setIcon(icon);
		jf.add(jl);
		JButton jb = new JButton("结束描点");
		jb.setBounds(w + 10, 10, 80, 30);
		jf.add(jb);

		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 监控点击选点事件
		jl.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.getX();
				int y = e.getY();
				l.add(new int[] { x, y });
				jf.repaint();
				// int gray = img[y][x];
				// System.out.println(x+"--"+y);
			}
		});

		// 监控结束选点点击事件
		jb.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				canReturn[0] = true;
			}
		});
		while (true) {
			if (canReturn[0]) {
				jf.dispose();
				return l;
			}
			// 睡眠一下，防止程序过多耗用空间
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 改变图片尺寸到指定大小
	 * 
	 * @param img
	 * @param width
	 * @param height
	 * @return
	 */
	public static BufferedImage changeImageSize(BufferedImage img, int width,
			int height) {
		BufferedImage result = new BufferedImage(width, height,
				BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = result.getGraphics();
		g.drawImage(img, 0, 0, width, height, null);
		return result;
	}

	public static BufferedImage changeImageSize(int[][] imgs, int width,
			int height) {
		Image img = getImage(imgs);
		BufferedImage result = new BufferedImage(width, height,
				BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = result.getGraphics();
		g.drawImage(img, 0, 0, width, height, null);
		return result;
	}
	/**
	 * Image 对象转BufferedImage对象
	 * 
	 * @param image
	 * @return
	 */
	public static BufferedImage toBufferedImage(Image image) {
		if (image instanceof BufferedImage) {
			return (BufferedImage) image;
		}

		// This code ensures that all the pixels in the image are loaded
		image = new ImageIcon(image).getImage();

		// Determine if the image has transparent pixels; for this method's
		// implementation, see e661 Determining If an Image Has Transparent
		// Pixels
		// boolean hasAlpha = hasAlpha(image);

		// Create a buffered image with a format that's compatible with the
		// screen
		BufferedImage bimage = null;
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		try {
			// Determine the type of transparency of the new buffered image
			int transparency = Transparency.OPAQUE;
			/*
			 * if (hasAlpha) { transparency = Transparency.BITMASK; }
			 */

			// Create the buffered image
			GraphicsDevice gs = ge.getDefaultScreenDevice();
			GraphicsConfiguration gc = gs.getDefaultConfiguration();
			bimage = gc.createCompatibleImage(image.getWidth(null),
					image.getHeight(null), transparency);
		} catch (HeadlessException e) {
			// The system does not have a screen
		}

		if (bimage == null) {
			// Create a buffered image using the default color model
			int type = BufferedImage.TYPE_INT_RGB;
			// int type = BufferedImage.TYPE_3BYTE_BGR;//by wang
			/*
			 * if (hasAlpha) { type = BufferedImage.TYPE_INT_ARGB; }
			 */
			bimage = new BufferedImage(image.getWidth(null),
					image.getHeight(null), type);
		}

		// Copy image to buffered image
		Graphics g = bimage.createGraphics();

		// Paint the image onto the buffered image
		g.drawImage(image, 0, 0, null);
		g.dispose();

		return bimage;
	}

	/**
	 * 根据灰度值获取图像
	 * 
	 * @param img
	 * @param title
	 * @return
	 */
	public static Image getImage(int[][] img) {
		int h = img.length;
		int w = img[0].length;

		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++) {
				int gray = img[i][j];
				int rgb = ((255 & 0xFF) << 24) | ((gray & 0xFF) << 16)
						| ((gray & 0xFF) << 8) | ((gray & 0xFF) << 0);
				bi.setRGB(j, i, rgb);
			}
		return bi;
	}

	/**
	 * 随机游走算法主体
	 * 
	 * @param grayImg
	 *            图像灰度值
	 * @param pointList
	 *            选点的坐标列表。
	 * @return 返回每个点对应的区域映射，二维矩阵和传入灰度图宽高相等，对应位置为1表示所属，对应位置为0表示不属于。
	 */
	public static Map<Point, int[][]> beginDevideImage(int[][] grayImg,
			List<Point> pointList) {
		System.out.println("Start");
		System.out.print("图片宽高：" + grayImg[0].length + "," + grayImg.length);
		System.out.println();
		int ii = 1;
		for (Point p : pointList) {
			System.out.print("坐标选点" + (ii++) + ":" + p.x + "," + p.y);
			System.out.println("," + grayImg[p.y][p.x]);
		}

		int row = grayImg.length;
		int col = grayImg[0].length;
		int K = pointList.size();
		int len = row * col;
		int lenU = len - K;
		int lenM = K;
		// 标记点Index
		List<Integer> VM = new ArrayList<Integer>();
		for (Point px : pointList) {
			int x = px.x;
			int y = px.y;
			int idx = y * col + x;
			VM.add(idx);
		}
		
		// 构造像素数组
		int[] source = new int[row * col];
		int index = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				source[index++] = grayImg[i][j];
				// System.out.println(source[index - 1]);
			}
		}

		// 定义拉普拉斯原始矩阵
		double[][] sourceLaplace = new double[row * col][row * col];
		// 计算原始拉普拉斯矩阵数值
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				// if i==j then di
				// else if i adjacent j then wij
				// else 0
				if (i == j) {

				} else if (adjancent(i, j, col)) {
					int gi = source[i];
					int gj = source[j];
					double weight = getWeight(gi, gj);
					sourceLaplace[i][j] = weight;
				} else {
					sourceLaplace[i][j] = 0;
				}
			}

		}
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (i != j) {

					sourceLaplace[i][i] += sourceLaplace[i][j];
				}
			}
		}
		
		// 通过dirichlet积分求导取极值得到：
		// LnX = - BTM
		// 第一步：求Ln
		double[][] Ln = new double[lenU][lenU];
		for (int i = 0, ti = 0; i < len; i++) {
			for (int j = 0, tj = 0; j < len; j++) {
				if (!VM.contains(i) && !VM.contains(j)) {
					Ln[ti][tj] = sourceLaplace[i][j];
					tj++;
				}
			}
			if (!VM.contains(i)) {
				ti++;
			}
		}
		
		// 第二部：求BT
		double[][] BT = new double[lenU][lenM];
		for (int i = 0; i < lenU; i++) {
			for (int j = 0; j < lenM; j++) {
				BT[i][j] = sourceLaplace[i + lenM][j];
			}
		}

		// 第三步：求M
		double[][] M = new double[K][K];
		for (int i = 0; i < K; i++) {
			M[i][i] = 1;
		}
		// 第四步：求解X
		Matrix mLn = new Matrix(Ln);
		Matrix mBT = new Matrix(BT);
		Matrix mM = new Matrix(M);

		Matrix temp = mBT.times(mM);
		temp = temp.times(-1);

		Matrix mLnNi = mLn.inverse();

		Matrix X = mLnNi.times(temp);
		// printArr(X.getArray());
		double[][] result = X.getArray();

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				result[i][j] = Math.abs(result[i][j]);
			}
		}

		// 第五步：划分区域
		double[][] tarIndex = new double[len][K];
		for (int i = 0; i < result.length; i++) {
			int ridx = maxIndex(result[i]);
			tarIndex[i][ridx] = 1;
		}
		for (int i = 0; i < VM.size(); i++) {
			for (int m = 0; m < K; m++) {
				int tii = VM.get(VM.size()-1-i);
				int j = tarIndex.length - 1;
				for (; j > tii; j--) {
					tarIndex[j][m] = tarIndex[j - 1][m];
				}
				for (int km = 0; km < K; km++) {
					if (i == km) {
						tarIndex[j][km] = 1;
					} else {
						tarIndex[j][km] = 0;
					}

				}
			}
		}
		
		printArr(tarIndex);
		double[][] test = new Matrix(tarIndex).transpose().getArray();
		for(int i=0;i<test.length;i++){
			//showImage(test[i], "123",col,0xffff0000);
			
			
		}
		
		return null;
	}

	/**
	 * 判断两点是否二维矩阵的一维化数组是否相邻
	 * 
	 * @param i
	 * @param j
	 * @param w
	 * @return
	 */
	public static boolean adjancent(int i, int j, int w) {

		if (i + 1 == j || i - 1 == j || i + w == j || i - w == j) {
			if (i == 6 || j == 6) {
				System.out.println(i + "--" + j);
			}
			return true;

		}

		return false;
	}

	/**
	 * 计算公式 Wij = exp(-2(wi-wj)^2) 其中wi 是目标点，wj 是灰度图个点
	 * 
	 * @param wi
	 *            目标点
	 * @param wj
	 *            散点
	 * @return
	 */
	public static double getWeight(int wi, int wj) {
		double re = wi - wj;
		re = Math.pow(re, 2);
		re = -90 * re;// 权值，可调整
		re = Math.exp(re);
		return re;
	}

	public static double max(double[] arr) {
		double max = arr[0];
		for (double d : arr) {
			if (d > max) {
				max = d;
			}
		}
		return max;
	}

	public static int maxIndex(double[] arr) {
		double max = arr[0];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			double d = arr[i];
			if (d > max) {
				max = d;
				index = i;
			}
		}
		return index;
	}

	public static void printArr(double[][] arr) {
		System.out.println(arr.length + "---" + arr[0].length);
		for (int i = 0; i < arr.length; i++)
			System.out.println(Arrays.toString(arr[i]));
		System.out.println("-----------------------------");
	}

	public static void printArr(int[][] arr) {
		System.out.println(arr.length + "---" + arr[0].length);
		for (int i = 0; i < arr.length; i++)
			System.out.println(Arrays.toString(arr[i]));
		System.out.println("-----------------------------");
	}
}
