package com.dyi.leetcode;
/**
 * 
 * @author stagebo
 * [1,2,3,4],[5,6,8]
 * return 4
 *
 */
public class FindMedian {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==nums2.length)return nums1[nums1.length-1]/2+nums2[0]/2;
        if(nums1.length>nums2.length){
            int s=nums2.length;
            int e=nums1.length-1;
            return find(nums1,s,e);
        }else{
            int s=nums1.length;
            int e=nums2.length-1;
            return find(nums2,s,e);
        }
        
    }
    public double find(int[] a,int s,int e){
        while(e-s>1){s++;e--;}
        if(s==e)return a[s];
        return a[s]/2+a[e]/2;
    }
}
