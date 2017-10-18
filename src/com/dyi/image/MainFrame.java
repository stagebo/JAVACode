package com.dyi.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class MainFrame extends JFrame {
	private File imgSource = null;
	private String imgSourceFileName = null;
	private List<Point> pointList = new ArrayList<Point>();
	private boolean choisePointStart = false;
	//储存计算结果。
	private Map<Point,int[][]> devideResult = null;

	public MainFrame() {
		this.setSize(800, 500);
		this.setLocation(200, 100);
		this.setLayout(null);
		
		JButton openFile = new JButton("打开文件");
		openFile.setBounds(10, 20, 120, 30);
		this.add(openFile);

		final JTextField showFileName = new JTextField();
		showFileName.setBounds(140, 20, 470, 30);
		this.add(showFileName);
		showFileName.setEditable(false);
		
		final JLabel showImg = new JLabel();
		showImg.setBounds(10, 60, 600, 400);
		showImg.setBorder(BorderFactory.createBevelBorder(1));
		this.add(showImg);

		JButton toGray = new JButton("灰度化");
		toGray.setBounds(620, 20, 120, 30);
		this.add(toGray);

		JButton choisePoint = new JButton("开始选点");
		choisePoint.setBounds(620, 60, 120, 30);
		this.add(choisePoint);

		JButton choisePointEnd = new JButton("结束选点");
		choisePointEnd.setBounds(620, 100, 120, 30);
		this.add(choisePointEnd);

		JButton resetData = new JButton("重置数据");
		resetData.setBounds(620, 140, 120, 30);
		this.add(resetData);
		
		JButton beginDevide = new JButton("开始处理");
		beginDevide.setBounds(620, 180, 120, 30);
		this.add(beginDevide);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		openFile.addMouseListener(new MouseListener() {

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
				imgSource = ImageDeal.openFile();
				imgSourceFileName = imgSource.getAbsolutePath();
				setBgImg(imgSource, showImg);
				showFileName.setText(imgSourceFileName);
			}
		});

		toGray.addMouseListener(new MouseListener() {

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
				String s = imgSource.getAbsolutePath();
				System.out.println(s);
				try {
					int[][] grayMax = ImageDeal.getGrayImage(s);
					Image img = ImageDeal.getImage(grayMax);
					setBgImg(img, showImg);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		choisePoint.addMouseListener(new MouseListener() {

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
				choisePointStart = true;
				// pointList = new ArrayList<int[]>();
			}
		});

		choisePointEnd.addMouseListener(new MouseListener() {

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
				choisePointStart = false;
			}
		});

		resetData.addMouseListener(new MouseListener() {

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
				pointList = new ArrayList<Point>();
				choisePointStart = false;
				if (imgSourceFileName != null) {
					setBgImg(new File(imgSourceFileName), showImg);
					repaint();
				}else if(imgSource != null){
					imgSourceFileName = imgSource.getAbsolutePath();
					setBgImg(new File(imgSourceFileName), showImg);
					repaint();
				}
			}
		});

		beginDevide.addMouseListener(new MouseListener() {
			
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
				try {
					int[][] grayImg = ImageDeal.getGrayImage(imgSourceFileName);
					//得到返回结果
					Map<Point,int[][]> result = ImageDeal.beginDevideImage(grayImg,pointList);
					
					//进行结果渲染
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		showImg.addMouseListener(new MouseListener() {

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
				if (choisePointStart) {
					int x = e.getX();
					int y = e.getY();
					pointList.add(new Point(x,y));
					repaint();
				}
			}
		});
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g_2d = (Graphics2D) g;
		int index = 1;
		for (Point p : pointList) {
			int x = p.x + 17;
			int y = p.y + 90;
			g_2d.setColor(Color.RED);
			g_2d.fillOval(x - 5, y - 5, 10, 10);
			g_2d.setFont(new Font("宋体", Font.BOLD, 20));
			g_2d.drawString("" + index++, x + 10, y + 10);
		}
	}

	public void setBgImg(File f, JLabel jl) {
		Image img = null;
		try {
			img = ImageIO.read(f);
		} catch (Exception ex) {
			return;
		}
		BufferedImage bimg = ImageDeal.toBufferedImage(img);
		BufferedImage bcImg = ImageDeal.changeImageSize(bimg, jl.getWidth(),
				jl.getHeight());
		ImageIcon icon = new ImageIcon(bcImg);
		jl.setIcon(icon);
	}

	public void setBgImg(Image img, JLabel jl) {
		BufferedImage bimg = ImageDeal.toBufferedImage(img);
		BufferedImage bcImg = ImageDeal.changeImageSize(bimg, jl.getWidth(),
				jl.getHeight());
		ImageIcon icon = new ImageIcon(bcImg);
		jl.setIcon(icon);
	}
}
