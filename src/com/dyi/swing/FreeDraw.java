package com.dyi.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 自由画板实现类
 * @author Stagebo
 *
 */
public class FreeDraw extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 标记是否初始化
	 */
	private boolean isInit = false;
	/**
	 * 标记需要更新的x、y坐标
	 */
	private int nx = 0, ny = 0;
	/**
	 * 
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setLayout(null);
		FreeDraw mp = new FreeDraw();
		mp.setBounds(20, 20, 300, 300);
		f.add(mp);
		f.setBounds(100, 100, 400, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	/**
	 * 构造函数，注册鼠标拖拽事件
	 */
	public FreeDraw() {
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

				int x = e.getX();
				int y = e.getY();

				refresh(x, y);
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}
	/**
	 * 画板更新函数，
	 * @param xx
	 * @param yy
	 */
	public void refresh(int xx, int yy) {
		System.out.println("refresh");
		nx = xx;
		ny = yy;
		repaint();
	}
	/**
	 * 重新绘制函数
	 */
	public void paint(Graphics g) {
		System.out.println("paint");
		if (!isInit) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());
			isInit = true;
			return;
		}
		g.setColor(Color.BLACK);
		g.fillRect(nx, ny, 10, 5);
	}

}