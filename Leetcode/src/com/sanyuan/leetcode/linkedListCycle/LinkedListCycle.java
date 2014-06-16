package com.sanyuan.leetcode.linkedListCycle;

import com.sanyuan.leetcode.util.datastructure.ListNode;

public class LinkedListCycle {


	static ListNode reverseList(ListNode l){
		if(l==null){
			return null;
		}
		if(l.next == null){
			return l;
		}
		ListNode next = l.next;
		l.next = null;
		ListNode tmp = reverseList(next);
		next.next = l;
		return tmp;
	}
	
	
	public static void main(String args[]){
		ListNode l1 = new ListNode(4);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(0);
		ListNode l4 = new ListNode(-4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l2;
		ListNode ret = reverseList(l1);
		while(ret.next!=null){
			ret = ret.next;
			System.out.println(ret.val);
		}
		System.out.println(ret.val);
		//System.out.print(l1==reverseList(l1));
		//System.out.print(reverseList(l1).val);
	}
}
