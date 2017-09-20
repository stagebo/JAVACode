package com.dyi.leetcode;

import com.dyi.utils.*;
/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * 
 * @author WANYONGBO
 * 
 */
public class Leet86PartitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNode head = new SingleNode(1);
		head.next=new SingleNode(4);
		head.next.next=new SingleNode(3);
		head.next.next.next=new SingleNode(2);
		head.next.next.next=new SingleNode(5);
		head.next.next.next.next=new SingleNode(2);
		SingleNode h = partition(head,3);
		
		while(h!=null){
			System.out.print(h.val+",");
		}
		System.out.println();

	}

	public static SingleNode partition(SingleNode head, int x) {
		SingleNode  l1 = new SingleNode(0),l2 = new SingleNode(0),th = head;
		/*step 1: find target*/
		int target;
		for(int i=0;i<x-1;i++){
			th = th.next;
		}
		target = th.val;
		/*step 2: */
		SingleNode tl1=l1,tl2=l2;
		while(head!=null){
			if(head.val<target){
				tl1.next=new SingleNode(head.val);
				tl1=tl1.next;
			}else{
				tl2.next = new SingleNode(head.val);
				tl2=tl2.next;
			}
			head=head.next;
		}
		l1=l1.next;
		l2=l2.next;
		tl1=l1;
		while(tl1.next!=null){
			tl1=tl1.next;
		}
		tl1.next=l2;
		return l1;
	}

}
