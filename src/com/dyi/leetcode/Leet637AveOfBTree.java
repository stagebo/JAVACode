package com.dyi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each
 * level in the form of an array.
 * 
 * Example 1: Input: 3 / \ 9 20 / \ 15 7 Output: [3, 14.5, 11] Explanation: The
 * average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is
 * 11. Hence return [3, 14.5, 11]. Note: The range of node's value is in the
 * range of 32-bit signed integer.
 * 
 * @author WANYONGBO
 * @version 2017Äê8ÔÂ8ÈÕ09:08:49
 */
public class Leet637AveOfBTree {
	List<double[]> sum = new ArrayList<double[]>();
	int index = 0;

	public List<Double> averageOfLevels(TreeNodeLeet637 root) {
		cal(root);
		System.out.println(sum.size());
		return null;
	}

	private void cal(TreeNodeLeet637 r) {
		if(r != null) {
			if (sum.size() > index) {
				double[] dt = sum.get(index);
				dt[0] += r.val;
				dt[1] += 1;
			} else {
				double[] dt = new double[2];
				dt[0] = r.val;
				dt[1] = 1;
				sum.add(dt);
			}
			index++;
			cal(r.left);
			cal(r.right);
			index--;

		}
	}

	public static void main(String[] args) {
		TreeNodeLeet637 root = new TreeNodeLeet637(6);
		root.createTree(root, 5);
		//root.preOrder(root);
		Leet637AveOfBTree leet=new Leet637AveOfBTree();
		leet.averageOfLevels(root);
		for(double[] d:leet.sum){
			System.out.println(Arrays.toString(d)+"--"+d[0]/d[1]);
		}
	}
}

/**
 * Definition for a binary tree node.
 */
class TreeNodeLeet637 {
	int val;
	TreeNodeLeet637 left;
	TreeNodeLeet637 right;

	TreeNodeLeet637(int x) {
		val = x;
	}

	public void createTree(TreeNodeLeet637 root, int n) {
		if (n < 1)
			return;
		root.left = new TreeNodeLeet637(n);
		root.right = new TreeNodeLeet637(n);
		createTree(root.left,n-1);
		createTree(root.right,n-1);
	}
	public void preOrder(TreeNodeLeet637 root){
		if(root==null)return;
		System.out.print(root.val+"  ");
		preOrder(root.left);
		preOrder(root.right);
	}
}
