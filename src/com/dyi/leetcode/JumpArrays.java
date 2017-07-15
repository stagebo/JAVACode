package com.dyi.leetcode;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * @author Stagebo
 *
 */
public class JumpArrays {
	public static void main(String[] args) {
		System.out.println(new JumpArrays().canJump(new int[] { 2, 5, 0, 0 }));
	}

	/**
	 * 1,最大步数。
	 * 
	 * 2,目标是index>nums.length-1.动态规划
	 * 
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
		return canJumpFromPosition(0, nums);
	}

	public boolean canJumpFromPosition(int position, int[] nums) {
		if (position == nums.length - 1) {
			return true;
		}

		int furthestJump = Math.min(position + nums[position], nums.length - 1);
		for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
			if (canJumpFromPosition(nextPosition, nums)) {
				return true;
			}
		}

		return false;
	}

}
