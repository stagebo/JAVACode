package com.dyi.test;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShowMergeSort {
    static int[] array = getArray(Tool.W);/* 获得长度为屏幕宽度的乱序数组 */
    static updateShowArrayImg m = new updateShowArrayImg(array);/* 先显示当前乱序数组 */

    /**
     * 归并排序，并将排序过程打印成图像
     * @param args
     */
    public static void main(String[] args) {
        MyJPanel show = m.show;
        /* 开局暂停两秒 */
        try {
            Thread.currentThread();
            Thread.sleep(2000);
        } catch (Exception e) {
        }

        /* 开始归并排序 */
        m.updateShowArray(array);
        devide(array, 0, array.length - 1);
        m.updateShowArray(array);
    }

    /* 构造一个长度为length的高度为length/2的数组 */
    public static int[] getArray(int length) {
        /* 生成空数组 */
        int[] re = new int[length];
        /* 给数组附上高为length/2的升序数值 */
        for (int i = 0; i < re.length; i++)
            re[i] = i / 2;
        /* 讲有序数组打乱 */
        for (int i = 0; i < 20 * re.length; i++) {
            int index1 = new Random().nextInt(length);
            int index2 = new Random().nextInt(length);
            int temp = re[index1];
            re[index1] = re[index2];
            re[index2] = temp;
        }

        return re;
    }

    /* 分解数据 */
    public static void devide(int[] array, int left, int right) {

        if (left < right) {
            /* 寻找到中间下标 */
            int mid = (right + left) / 2;
            /* 从中间下标隔断，将前后两段分别分解 */
            devide(array, left, mid);
            /* 继续分割第二段 */
            devide(array, mid + 1, right);
            /* 分割完了，调用归并 */
            merge(array, left, mid, mid + 1, right);
        }
    }

    /* 归并，包含排序 */
    public static void merge(int[] array, int leftStart, int leftEnd,
            int rightStart, int rightEnd) {
        /* 新建临时数组，存放该次归并后的数据 */
        int[] temp = new int[array.length];
        /* 记录归并的左组和右组开始结束下标 */
        int ls = leftStart, le = leftEnd, rs = rightStart, re = rightEnd;
        /* 记录临时数组的存放位置 */
        int index = ls;
        /* 第一次比较归并，左组合右组中较小的入temp */
        while (ls <= le && rs <= re) {
            if (array[ls] <= array[rs]) {
                temp[index] = array[ls];
                index++;
                ls++;
            } else {
                temp[index] = array[rs];
                index++;
                rs++;
            }
        }
        /* 第二次选择归并，将array中剩余的未加入temp的数加入到temp中 */
        while (ls <= le) {
            temp[index] = array[ls];
            ls++;
            index++;
        }
        while (rs <= re) {
            temp[index] = array[rs];
            rs++;
            index++;
        }
        /* temp是经过调整后的array，此时一次归并完毕，返回数据进行下一次归并 */
        while (leftStart <= rightEnd) {
            array[leftStart] = temp[leftStart];
            leftStart += 1;
        }
        try{Thread.sleep(8);}catch(Exception e){}
        /* 打印本次归并结果,输出成图像 */
        m.updateShowArray(array);
    }

    /* 打印数组 */
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + "  ");
        System.out.println();
    }

}

/* 工具类，获取当前屏幕大小，用户初始化显示组件和new乱序数组 */
class Tool {
    public static int W = (int) Toolkit.getDefaultToolkit().getScreenSize()
            .getWidth();/* 当前屏幕宽度 */
    public static int H = (int) Toolkit.getDefaultToolkit().getScreenSize()
            .getHeight();/* 当前屏幕高度 */
}

/* 画图面板 */
class MyJPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    int[] array;/* 用于接收构造方法传过来的数组，用于绘图 */

    public MyJPanel(int[] a) {
        array = a;
    }

    /* 绘图函数 */
    public void paintComponent(Graphics g) {
        /* 画笔置白色 */
        g.setColor(Color.WHITE);
        /* 擦除上一次绘制的团 */
        g.fillRect(0, 0, Tool.W, Tool.H);
        /* 画笔置黑色 */
        g.setColor(Color.black);
        /* 开始绘制当前数组图像，以（0,Tool.H）为原点，向右为x轴表数组下标，向上为y轴表当前下标所对应数组存置大小 */
        for (int i = 0; i < array.length; i++) {
            g.drawLine(i, Tool.H - 80, i, Tool.H - array[i] - 80);
        }

    }
}

/* 显示主框架JFrame类 */
class updateShowArrayImg extends JFrame {
    private static final long serialVersionUID = 1L;
    MyJPanel show;

    /* 构造函数，初始化显示框架 */
    public updateShowArrayImg(int[] a) {
        show = new MyJPanel(a);
        show.setBounds(0, 0, Tool.W, Tool.H);
        this.setSize(Tool.W, Tool.H);
        this.setTitle("归并排序");
        this.setLocation(0, 0);
        this.add(show);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * 更新画布
     * 
     * @param a
     */
    public void updateShowArray(int[] a) {
        this.remove(show);
        show = new MyJPanel(a);
        this.add(show);
        this.setVisible(true);
    }
}

