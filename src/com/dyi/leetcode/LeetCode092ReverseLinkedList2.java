package com.dyi.leetcode;

import com.dyi.entity.OneWayNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 ¡Ü m ¡Ü n ¡Ü length of list.
 * 
 * @author WANYONGBO
 * 
 */
public class LeetCode092ReverseLinkedList2 {
	public static void main(String[] args) {
		OneWayNode head = new OneWayNode(1);
		OneWayNode t = head;
		for(int i=2;i<6;i++){
			t.next=new OneWayNode(i);
			t=t.next;
		}
		
	}
	public static OneWayNode reverseLinkedList(OneWayNode head,int m,int n){
		if(head == null||head.next==null){
			return head;
		}
		if(m>=n){
			return head;
		}
		
		OneWayNode tf=null,tl=null,th=head;
		for(int i=0;i<n-1;i++){
			if(i==m){
				tf=th;
			}
			th=th.next;
		}
		
		return null;
	}
	
	
}
