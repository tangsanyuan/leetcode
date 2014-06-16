package com.sanyuan.leetcode.util.datastructure;



public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) {
		val = x;
		next = null;
	}
	
	
	public void printList(){
		ListNode idx = this;
		while(idx != null){
			System.out.print(idx.val + "->");
			idx = idx.next;
		}
		System.out.print("null\n");
	}
}