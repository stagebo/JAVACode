package com.dyi.leetcode;

/**
 * 
 * @author stagebo 
 * 		   There are two sorted arrays nums1 and nums2 of size m and n
 *         respectively.
 * 
 *         Find the median of the two sorted arrays. The overall run time
 *         complexity should be O(log (m+n)).
 * 
 *         Example 1: nums1 = [1, 3] nums2 = [2]
 * 
 *         The median is 2.0 
 *         
 *         Example 2: nums1 = [1, 2] nums2 = [3, 4]
 * 
 *         The median is (2 + 3)/2 = 2.5
 */
public class FindMedian_01 {
	 public double findMedianSortedArrays(int[] n1, int[] n2) {
	        double[] a=new double[n1.length+n2.length];
	        int k1=0,k2=0,i=0;
	        while(k1<n1.length&&k2<n2.length){
	            if(n1[k1]<n2[k2])a[i++]=n1[k1++];
	            else a[i++]=n2[k2++];
	            
	        }
	        while(k1<n1.length)
	            a[i++]=n1[k1++];
	        while(k2<n2.length)
	            a[i++]=n2[k2++];
	        if( a.length%2==0)
	            return (a[a.length/2]+a[a.length/2-1])/2;
	        else return a[(a.length-1)/2];
	    }
	    
}
