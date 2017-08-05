package com.dyi.test;


import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.*;

public class InsertionSort extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * main method
     * 
     * @param args
     *            []
     * @author stagebo
     */
    static int[] arr = getArray(1000);
    static InsertionSort show;
    public static void main(String[] args) {
        show=new InsertionSort("≤Â»Î≈≈–Ú");
        insertionSort(arr);
    }

    /**
     * introduction:algorithms of insertionSort
     * 
     * @param arr
     *            []
     * @return void
     * 
     */
    public static void insertionSort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i;
            for (i = j - 1; i >= 0 && arr[i] > key; i--) {
                arr[i + 1] = arr[i];
                try{Thread.sleep(1);}catch(Exception e){}
                show.repaint();
            }
            arr[i + 1] = key;
        }
    }

    /**
     * function: print array
     * 
     * @param arr
     * @param str
     */
    public static void printArray(int[] arr, String str) {
        System.out.print(str + ":");
        for (int i : arr) {
            System.out.print(i + "--");
        }
        System.out.println();
    }

    /**
     * constructor,initial the panel
     */
    public InsertionSort(String title) {
        setTitle(title);
        setLocation(20, 20);
        setSize(1000, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        for (int i = 0; i < arr.length; i++) {
            g.setColor(Color.BLACK);
            g.drawLine(i, 600, i, 600-arr[i]);
            g.setColor(Color.WHITE);
            g.drawLine(i, 0,i, 600-arr[i]);
        }
    }

    /**
     * return a random value array
     * 
     * @param length
     * @return array[length]
     */
    public static int[] getArray(int length) {
        int[] re = new int[length];
        for (int i = 0; i < re.length; i++)
            re[i] = i / 2;
        for (int i = 0; i < re.length; i++) {
            int index1 = new Random().nextInt(length);
            for (int j = 0; j < 3; j++) {
                int temp = re[i];
                re[i] = re[index1];
                re[index1] = temp;
            }
        }
        return re;
    }
}

