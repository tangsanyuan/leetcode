package com.sanyuan.leetcode.reorderList;

public class ReorderList {
	public static void main(String args[]){
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		reorderList(l1);
		while(l1!=null){
			System.out.print(l1.val+" ");
			l1 = l1.next;
		}
	}


	public static void reorderList(ListNode head) {
		if(head==null || head.next == null){
			return;
		}
		//1. Get middle of the list
		ListNode mid = getMiddleNode(head);
		//2. reverse the second half of the list;
		ListNode prev = reverseList(mid);
		//3. cur is the head of second half/ merge cur and head;
		mergeLists(head, prev);
	}


	private static void mergeLists(ListNode head, ListNode prev) {
		ListNode l1 = head;
		ListNode l2 = prev;
		while(l1!=null && l2!=null){
			ListNode t1 = l1.next;
			ListNode t2 = l2.next;
			l1.next = l2;
			l2.next = t1==null ?  t2 : t1 ;
			l1 = t1;
			l2 = t2;
		}
	}


	private static ListNode reverseList(ListNode mid) {
		ListNode prev = null;
		ListNode next = mid.next;
		ListNode cur = mid;
		while(cur!=null){
			ListNode tmp = next;
			cur.next = prev;
			prev = cur;
			cur = tmp;
			next = tmp==null ? null: tmp.next;
		}
		return prev;
	}


	private static ListNode getMiddleNode(ListNode head) {
		ListNode slow = head;
		ListNode faster = head.next;
		while(faster!=null){
			faster = faster.next;
			if(faster != null){
				faster = faster.next;
			}else{
				break;
			}
			slow = slow.next;
		}
		ListNode mid = slow.next;
		slow.next = null;
		return mid;
	}
}
