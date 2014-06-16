package com.sanyuan.leetcode.remvoeDuplciateFromLinkedList;

import com.sanyuan.leetcode.util.datastructure.ListNode;

public class RemoveDuplicateFromLikedList {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode ret = head;
        while(head!=null){
              ListNode next = head.next;
              while(next!=null && next.val == head.val){
                    next = next.next;
              }
              head.next = next;
              head = head.next;
        }
        return ret;
    }
}
