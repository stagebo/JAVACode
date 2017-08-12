package com.dyi.leetcode;

/**
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 * 
 * Example:
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 * 	       10 
 *		  / \ 
 *       5  -3 
 *      / \   \ 
 *     3   2   11 
 *    / \   \ 
 *   3 -2    1
 * 
 * Return 3. The paths that sum to 8 are:
 * 
 * 1. 5 -> 3 
 * 2. 5 -> 2 -> 1 
 * 3. -3 -> 11
 * 
 * @author WANYONGBO
 *
 */
public class Leet437SumPath {
	int s;
	int result;

	public int pathSum(Node root, int sum) {
		this.s = sum;
		result = 0;
		findSum(root);
		return result;
	}

	public void findSum(Node root) {
		if (root == null)
			return;
		int t = canSum(root, s);
		result += t;
		findSum(root.left);
		findSum(root.right);
	}

	public int canSum(Node root, int sum) {
		if (root == null)
			return 0;
		if (sum == root.val)
			return 1;
		sum -= root.val;
		return canSum(root.left, sum) + canSum(root.right, sum);
	}

	public static void main(String[] args) {
		Leet437SumPath le = new Leet437SumPath();
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(-3);
		root.left.left = new Node(3);
		root.left.right = new Node(2);
		root.right.right = new Node(11);
		root.left.left.left = new Node(3);
		root.left.left.right = new Node(-2);
		root.left.right.right = new Node(1);

		System.out.println(le.pathSum(root, 8));
	}
}
