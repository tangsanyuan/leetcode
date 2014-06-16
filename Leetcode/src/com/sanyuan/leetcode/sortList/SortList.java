package com.sanyuan.leetcode.sortList;

import com.sanyuan.leetcode.util.datastructure.ListNode;

public class SortList {
	
	public static void main(String args[]){
		ListNode head = new ListNode(2);
		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(1);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		ListNode tmp = sortList(head);
		tmp.printList();
		
		System.out.println("Empty string size is " + "a".substring(0,1));
		
	}
	
	
	
	static ListNode sortList(ListNode head) {
        int length = 0;
        ListNode run = head;
        while(run!=null){
            length++;
            run = run.next;
        }
        return mergeSort(head,length);
    }
    
    static ListNode mergeSort(ListNode head, int length){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        int count = length / 2;
        int size = count;
        ListNode pivot = head;
        while(count > 1){
            pivot = pivot.next;
            count--;
        }
        ListNode tmp = pivot.next;
        pivot.next = null;
        ListNode l1 = mergeSort(head,size);
        ListNode l2 = mergeSort(tmp,size);
        return merge(l1, l2);
    }
    
    static ListNode merge(ListNode slow, ListNode fast){
    	ListNode head = new ListNode(0);
		ListNode cur = head;
		while (slow != null && fast != null) {
			if (slow.val < fast.val) {
				cur.next = slow;
				slow = slow.next;
			} else {
				cur.next = fast;
				fast = fast.next;
			}
			cur = cur.next;
		}
		if (slow != null) {
			cur.next = slow;
		} else if (fast != null) {
			cur.next = fast;
		}
		return head.next;
        
    }
}
